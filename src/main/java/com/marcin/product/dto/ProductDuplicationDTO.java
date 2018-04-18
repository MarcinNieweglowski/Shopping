package com.marcin.product.dto;

public class ProductDuplicationDTO {

	private int existingProductId;
	private String existingProductName;
	
	public int getExistingProductId() {
		return existingProductId;
	}

	public void setExistingProductId(int existingProductId) {
		this.existingProductId = existingProductId;
	}

	public String getExistingProductName() {
		return existingProductName;
	}

	public void setExistingProductName(String existingProductName) {
		this.existingProductName = existingProductName;
	}

	@Override
	public String toString() {
		return "ProductDuplicationDTO [existingProductId=" + existingProductId + ", existingProductName=" + existingProductName + "]";
	}
	
}
