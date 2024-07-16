package com.example.first.Repository;

import java.util.List;

import com.example.first.model.Product;

public interface IProductRepository {
    public void addProduct(Product product);

    public Product findProduct(int id);

    public List<Product> AllProducts();

}
