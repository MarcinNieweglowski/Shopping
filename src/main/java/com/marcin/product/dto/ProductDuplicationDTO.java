package com.marcin.product.dto;

public class ProductDuplicationDTO {

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductDuplicationDTO [productName=" + productName + "]";
	}
	
}
