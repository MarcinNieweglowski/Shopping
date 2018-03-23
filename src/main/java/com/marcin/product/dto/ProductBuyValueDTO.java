package com.marcin.product.dto;

public class ProductBuyValueDTO {
	String productName;
	int toBuyValue;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getToBuyValue() {
		return toBuyValue;
	}
	public void setToBuyValue(int toBuyValue) {
		this.toBuyValue = toBuyValue;
	}
	@Override
	public String toString() {
		return "ProductBuyValueDTO [productName=" + productName + ", toBuyValue=" + toBuyValue + "]";
	}
	//nowa linia
	
}
