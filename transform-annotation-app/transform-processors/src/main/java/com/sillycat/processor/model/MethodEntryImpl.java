package com.sillycat.processor.model;

import javax.lang.model.element.ExecutableElement;

public class MethodEntryImpl implements MethodEntry {
	@SuppressWarnings("unused")
	private ExecutableElement self;

	public MethodEntryImpl(ExecutableElement self) {
		this.self = self;
	}
}
