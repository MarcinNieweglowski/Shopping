package com.marcin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.product.dao.ProductDAO;
import com.marcin.product.dto.ProductBuyValueDTO;
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
	public void saveProduct(Product theProduct) {
		productDAO.saveProduct(theProduct);
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
		for (Product item: productDAO.showBuyList()) {
			ProductBuyValueDTO dto = new ProductBuyValueDTO();
			dto.setId(item.getId());
			dto.setProductName(item.getProductName());
			dto.setToBuyValue(item.getQuantityNeeded()-item.getStatus());
			results.add(dto);
		}
		
		return results;
	}
}
