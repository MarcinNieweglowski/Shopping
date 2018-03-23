package com.marcin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.product.dao.ProductDAO;
import com.marcin.product.dto.ProductBuyValueDTO;
import com.marcin.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<ProductBuyValueDTO> toBuyValue() {
		List<ProductBuyValueDTO> results = new ArrayList<>();
		for (Product item: productDAO.getProductList()) {
			ProductBuyValueDTO dto = new ProductBuyValueDTO();
			dto.setProductName(item.getProductName());
			dto.setToBuyValue(item.getQuantityNeeded()-item.getStatus());
			results.add(dto);
		}
		
		return results;
	}

}
