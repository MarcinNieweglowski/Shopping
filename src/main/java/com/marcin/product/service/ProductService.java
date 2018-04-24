package com.marcin.product.service;

import java.util.List;

import com.marcin.product.dto.ProductBuyValueDTO;
import com.marcin.product.entity.Product;

public interface ProductService {
	
	public List<Product> getProductList();
	public void saveProduct(Product theProduct);
	public Product updateProduct(int theId);
	public void deleteProduct(int theId);
	
	//show the list of items (status < needed value)
	public List<Product> showBuyList();
	
	// set the status = value needed
	public Product setMax(int theId);
	
	// calculate the value needed to buy (of a given product)
	public List<ProductBuyValueDTO> toBuyValue();

	// check if a given product already exists in the database
	public boolean productDoesNotExist(int newId, String newProductName);
	public boolean productDoesNotExist(String newProductName);
	// search the database to find the exact product
	public Product findProductInDatabaseForSearchMethod(Product searchProduct);
}
