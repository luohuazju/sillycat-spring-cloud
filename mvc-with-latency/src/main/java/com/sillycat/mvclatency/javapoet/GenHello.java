package com.sillycat.mvclatency.javapoet;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class GenHello {

	public static void main(String[] args) throws IOException {
		//main method
		MethodSpec main = MethodSpec.methodBuilder("main")   //method name
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)                          
                .addParameter(String[].class, "args")      
                .addStatement("$T.out.println($S)", System.class, "Hello, Kiko")  //T for type, S for string?
                .build();
		
		//Hello class
		TypeSpec hello = TypeSpec.classBuilder("Hello")
				.addModifiers(Modifier.PUBLIC)
				.addMethod(main)
				.build();
		//Java source file generate
		JavaFile javaFile = JavaFile.builder("com.sillycat.mvclatency.javapoet", hello)
				.build();
		javaFile.writeTo(System.out); //just print out the contents
		//generate java source
		File file = new File("/Users/huluo/work/sillycat/sillycat-spring-cloud/mvc-with-latency/src/main/java/");
		javaFile.writeTo(file);
	}

}
