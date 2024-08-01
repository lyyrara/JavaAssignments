package com.example.first.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.model.Product;
import com.example.first.service.IProductService;





@RestController
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	IProductService productService;

	public ProductController() {
	}
	
	
	@PostMapping("addproduct")
	public String login( @RequestBody Product product) {
		System.out.println(product.toString());
		
		productService.addProduct(product);
		return "Add product Successfull";
	}
    

    @PostMapping("findproduct")
    public String findProduct(@RequestBody Product product) {
		Product p = productService.findProduct(product.getProductid());
		if(p == null){
			return "Product not found.";
		}
		
		return "Find Successfull "+product.toString();
    }

	@GetMapping("list")
	public String listAllProducts() {
		List<Product> res =  productService.AllProducts();
		if(res == null){
			return "No Product.";
		}
		else{
			for(Product p: res){
				System.out.println(p.toString());
			}
		}
		return "All products listed";
	}
	

}