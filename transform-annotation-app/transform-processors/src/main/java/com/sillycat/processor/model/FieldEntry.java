package com.sillycat.processor.model;

import javax.lang.model.element.Element;

import com.squareup.javapoet.MethodSpec;

public interface FieldEntry {

	String getName();

	TypeEntry getType();

	String getGetter();

	String getSetter();

	Element getElement();

	void transformTo(FieldEntry to, TransformerClass env, MethodSpec.Builder builder);

}
