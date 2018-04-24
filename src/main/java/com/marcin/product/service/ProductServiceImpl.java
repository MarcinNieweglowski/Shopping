package com.marcin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.product.dao.ProductDAO;
import com.marcin.product.dto.ProductBuyValueDTO;
import com.marcin.product.dto.ProductDuplicationDTO;
import com.marcin.product.dto.SearchProductDTO;
import com.marcin.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Override
	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

	@Transactional
	@Override
	public void saveProduct(Product theProduct){
		if (productDoesNotExist(theProduct.getId(), theProduct.getProductName())) {	//true - product CAN be added, false - already exists
			productDAO.saveProduct(theProduct);
		}
	}

	@Transactional
	@Override
	public Product updateProduct(int theId) {
		return productDAO.updateProduct(theId);
	}

	@Transactional
	@Override
	public void deleteProduct(int theId) {
		productDAO.deleteProduct(theId);
	}

	@Transactional
	@Override
	public List<Product> showBuyList() {
		return productDAO.showBuyList();
	}

	@Transactional
	@Override
	public Product setMax(int theId) {
		return productDAO.setMax(theId);
	}

	@Transactional
	@Override
	public List<ProductBuyValueDTO> toBuyValue() {
		List<ProductBuyValueDTO> results = new ArrayList<>();
		for (Product item : productDAO.showBuyList()) {
			ProductBuyValueDTO dto = new ProductBuyValueDTO();
			dto.setId(item.getId());
			dto.setProductName(item.getProductName());
			dto.setToBuyValue(item.getQuantityNeeded()-item.getStatus());
			results.add(dto);
		}
		return results;
	}

	@Transactional
	@Override
	public boolean productDoesNotExist(int newId, String newProductName) {	//true - product not in DB / CAN be added, false - already exists
		String existingProductName;
		int existingProductId;
		
		newProductName = newProductName.toLowerCase();
		
		for (Product item : productDAO.getProductList()) {
			ProductDuplicationDTO duplicatedProduct = new ProductDuplicationDTO();
			
			duplicatedProduct.setExistingProductId(item.getId());
			existingProductId = duplicatedProduct.getExistingProductId();
			
			duplicatedProduct.setExistingProductName(item.getProductName());
			existingProductName = duplicatedProduct.getExistingProductName().toLowerCase();
			
			if (existingProductId != newId && existingProductName.equals(newProductName)) {	// equal ids -> updating an existing product
				return false;
			}
		}
		return true;
	}
	
	@Transactional
	@Override
	public boolean productDoesNotExist(String newProductName) {	//true - product not in DB / CAN be added, false - already exists
		String searchNameInDatabase;
		newProductName = newProductName.toLowerCase();
		
		for (Product item : productDAO.getProductList()) {
			SearchProductDTO searchProductDTO = new SearchProductDTO();
			searchProductDTO.setSearchName(item.getProductName());
			searchNameInDatabase = searchProductDTO.getSearchName().toLowerCase();
			
			if (searchNameInDatabase.equals(newProductName)) {
				return false;
			}
		}
		return true;
	}

	@Transactional
	@Override
	public Product findProductInDatabaseForSearchMethod(Product searchProduct) {
		String searchNameInDatabase;
		String productName = searchProduct.getProductName().toLowerCase();
		
		for (Product item : productDAO.getProductList()) {
			SearchProductDTO searchProductDTO = new SearchProductDTO();
			searchProductDTO.setSearchName(item.getProductName());
			searchNameInDatabase = searchProductDTO.getSearchName().toLowerCase();
			
			if (searchNameInDatabase.equals(productName)) {
				return item;
			}
		}
		return null;
	}
}
