package com.marcin.product.validation;

@SuppressWarnings("serial")
public class ProductExistsException extends Throwable {

	public ProductExistsException(final String message) {
		super(message);
	}
}
