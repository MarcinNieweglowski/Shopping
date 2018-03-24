package com.marcin.product.dto;

public class ProductBuyValueDTO {
	
	int id;
	String productName;
	int toBuyValue;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
		return "ProductBuyValueDTO [id=" + id + ", productName=" + productName + ", toBuyValue=" + toBuyValue + "]";
	}
	
}
