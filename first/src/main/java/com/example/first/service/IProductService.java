package com.example.first.service;

import java.util.List;

import com.example.first.model.Product;

public interface IProductService {
    public void addProduct(Product product) ;

    public Product findProduct(String productid);

    public List<Product> AllProducts();

}
