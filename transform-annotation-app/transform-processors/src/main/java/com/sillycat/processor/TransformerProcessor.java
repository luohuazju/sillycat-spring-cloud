package com.sillycat.processor;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import com.google.common.collect.ImmutableSet;
import com.sillycat.annotation.Transformer;
import com.sillycat.processor.model.EntryFactory;
import com.sillycat.processor.model.TransformerClass;
import com.sillycat.processor.model.TransformerMethod;
import com.sillycat.processor.model.TypeEntry;

@SupportedAnnotationTypes("com.sillycat.annotation.Transformer")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TransformerProcessor extends AbstractProcessor {

	private final String transformerTemplate = "template/TransformerTemplate.vm";

	public TransformerProcessor() {
		super();
	}

	public SourceVersion getSupportedSourceVersion() {
		if (SourceVersion.latest().compareTo(SourceVersion.RELEASE_8) > 0) {
			return SourceVersion.latest();
		} else {
			return SourceVersion.RELEASE_8;
		}
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return ImmutableSet.of(Transformer.class.getCanonicalName());
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		roundEnv.getElementsAnnotatedWith(Transformer.class).stream().filter(TypeElement.class::isInstance)
				.map(TypeElement.class::cast).forEach(this::generateTransformer);
		return true;
	}
	
	private void generateTransformer(TypeElement orig) {
        TypeEntry clazz = EntryFactory.of(orig.asType());
        TransformerClass transformer = new TransformerClass(clazz, processingEnv);

        List<TypeEntry> fromTypes = TypeEntry.getTransformerClasses(clazz, "from");
        List<TypeEntry> toTypes = TypeEntry.getTransformerClasses(clazz, "to");

        fromTypes.forEach(c -> transformer.addTransformerMethod(TransformerMethod.of(c, clazz, "from"+c.getName())));
        toTypes.forEach(c -> transformer.addTransformerMethod(TransformerMethod.of(clazz, c, "to"+c.getName())));

        final Filer filer = processingEnv.getFiler();
        try {
            transformer.generate().writeTo(filer);
		} catch (IOException ex) {
            throw new TransformerProcessingException(orig, "could not output processing result to file '"
                    + clazz.getName() + "Transformer"
                    + "'.", ex);
        }
    }

}
