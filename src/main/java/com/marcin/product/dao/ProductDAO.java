package com.marcin.product.dao;

import java.util.List;

import com.marcin.product.entity.Product;

public interface ProductDAO {

	public List<Product> getProductList();
	public void saveProduct(Product theProduct);
	public Product updateProduct(int theId);
	public void deleteProduct(int theId);
	public List<Product> showBuyList();
	public Product setMax(int theId);
}
