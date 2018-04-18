package com.marcin.product.service;

import java.util.List;

import com.marcin.product.dto.ProductBuyValueDTO;
import com.marcin.product.entity.Product;

public interface ProductService {
	
	// list of all products
	public List<Product> getProductList();
	
	// add a new product
	public void saveProduct(Product theProduct)/* throws ProductExistsException*/;
	
	// update a given product
	public Product updateProduct(int theId);
	
	// delete a given product
	public void deleteProduct(int theId);
	
	//show the list of items (status < needed value)
	public List<Product> showBuyList();
	
	// set the status = value needed
	public Product setMax(int theId);
	
	// calculate the value needed to buy (of a given product)
	public List<ProductBuyValueDTO> toBuyValue();

	// check if a given product already exists in the database
	public boolean productDoesNotExist(int newId, String newProductName);
}
