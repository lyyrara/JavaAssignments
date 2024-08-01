package com.example.first.Repository;

import java.util.List;

import com.example.first.model.Product;

public interface IProductRepository {
    public void addProduct(Product product);

    public Product findProduct(String productid);

    public List<Product> AllProducts();

}
