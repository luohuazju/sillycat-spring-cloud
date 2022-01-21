package com.sillycat.processor;

import javax.lang.model.element.Element;

public class TransformerProcessingException extends RuntimeException {

	private static final long serialVersionUID = -2468193747827342475L;
	
	private final Element element;
	private final String message;
	private final Throwable cause;

	public TransformerProcessingException(Element element, String message, Throwable cause) {
		this.element = element;
		this.message = message;
		this.cause = cause;
	}

	public TransformerProcessingException(String message) {
		this.element = null;
		this.message = message;
		this.cause = null;

	}

	public Element getElement() {
		return this.element;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}

}
