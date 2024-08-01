package com.example.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.Repository.IProductRepository;
import com.example.first.model.Product;

@Service
public class ProductServiceImpl implements IProductService{
    
    @Autowired
	IProductRepository productRepository;

    

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);    
    }

    @Override
    public Product findProduct(String productid) {
        Product product = productRepository.findProduct(productid);
        return product;
    }

    @Override
    public List<Product> AllProducts() {
        return productRepository.AllProducts();
    }
    
}
