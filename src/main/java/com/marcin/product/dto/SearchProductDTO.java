package com.marcin.product.dto;

public class SearchProductDTO {

	private int id;
	private String searchName;
	private int searchQuantityNeeded;
	private int searchStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public int getSearchQuantityNeeded() {
		return searchQuantityNeeded;
	}
	public void setSearchQuantityNeeded(int searchQuantityNeeded) {
		this.searchQuantityNeeded = searchQuantityNeeded;
	}
	public int getSearchStatus() {
		return searchStatus;
	}
	public void setSearchStatus(int searchStatus) {
		this.searchStatus = searchStatus;
	}
	
	@Override
	public String toString() {
		return "SearchProductDTO [id=" + id + ", searchName=" + searchName + ", searchQuantityNeeded="
				+ searchQuantityNeeded + ", searchStatus=" + searchStatus + "]";
	}
	
}
