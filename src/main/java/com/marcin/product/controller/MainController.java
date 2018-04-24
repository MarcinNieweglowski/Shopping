package com.marcin.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcin.product.entity.Product;
import com.marcin.product.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);	// true -> if everything is whitespace -> will trim to null
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/main")
	public String mainView() {
		return "main";
	}
	
	@GetMapping("/showList")
	public String showListView(Model theModel) {
		List<Product> theProduct = productService.getProductList();
		theModel.addAttribute("products", theProduct);
		return "show-list";
	}
	
	@GetMapping("/productForm")
	public String showProductForm(Model theModel) {
		Product theProduct = new Product();
		theModel.addAttribute("addProduct", theProduct);
		return "product-form";
	}
	
	@PostMapping("/confirmProduct")
	public String confirmProduct(@Valid @ModelAttribute("addProduct") Product registerProduct, BindingResult result, Model theModel) {
		String productNameNotNull = registerProduct.getProductName();
		if (productNameNotNull == null || result.hasErrors()) {
			theModel.addAttribute("formerrors", result.getAllErrors()); // to avoid HTTP Status 500 - Internal Server Error
			return "product-form";
		}
		
		boolean isValidName = productService.productDoesNotExist(registerProduct.getId(), registerProduct.getProductName());
		if (!isValidName) {
			theModel.addAttribute("isInvalidName", "A product with this name already exists. Duplicate entries are not allowed.");
			return "product-form";
		} else {
			productService.saveProduct(registerProduct);
			return "redirect:/showList";
		}
	}
	
	@GetMapping("/buyList")
	public String showBuyList(Model theModel) {
		theModel.addAttribute("productToBuy", productService.toBuyValue());
		return "buy-list";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam("updateId") int theId, Model theModel) {
		Product theProduct = productService.updateProduct(theId);
		theModel.addAttribute("addProduct", theProduct);
		return "product-form";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("deleteId") int theId) {
		productService.deleteProduct(theId);
		return "redirect:/showList";
	}
	
	@GetMapping("/setMaxVal")
	public String setMaxStatus(@RequestParam("setMaxStatus") int theId, Model theModel) {
		Product theProduct = productService.setMax(theId);
		theModel.addAttribute("setMaxStatus", theProduct);
		return "redirect:/buyList";
	}
	
	@GetMapping("/searchProduct")
	public String searchProduct(Model theModel) {
		Product searchProduct = new Product();
		theModel.addAttribute("requestProductName", searchProduct);
		return "search-product";
	}
	
	@PostMapping("/searchResult")
	public String searchResult(@ModelAttribute("requestProductName") Product searchProduct, Model theModel) {
		try {
			boolean productNotInDatabase = productService.productDoesNotExist(searchProduct.getProductName());
			if (productNotInDatabase) {
				return "search-no-result-found";
			}
			Product theProduct = productService.findProductInDatabaseForSearchMethod(searchProduct);
			theModel.addAttribute("requestProductName", theProduct);
			return "search-result";
		} catch (NullPointerException nullExc) {
			return "redirect:/searchProduct";
		}
	}
}
