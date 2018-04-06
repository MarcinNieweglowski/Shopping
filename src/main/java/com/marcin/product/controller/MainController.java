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
import org.springframework.web.bind.annotation.RequestMapping;
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
		if(result.hasErrors()) {
			theModel.addAttribute("formerrors", result.getAllErrors()); // CHECK IT!
			//System.out.println("\nTHE ERRORS ARE: " + result);
			return "product-form";
		} else {
			productService.saveProduct(registerProduct);
			return "redirect:/showList";
		}
	}
	
/*	private Product createNewProduct(Product product, BindingResult result) {
		Product newProduct = null;
		try {
			newProduct = productService.saveProduct(product);
		} catch (ProductExistsException exc) {
			return null;
		}
	}*/
	
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
	
	@RequestMapping("/setMaxVal")
	public String setMaxStatus(@RequestParam("setMaxStatus") int theId, Model theModel) {
		Product theProduct = productService.setMax(theId);
		theModel.addAttribute("setMaxStatus", theProduct);
		return "redirect:/buyList";
	}
	
}
