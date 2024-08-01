package com.example.first.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.first.model.Product;


@Repository
public class ProductRepositoryImpl implements IProductRepository{
    List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(products.size());
    
    }

    @Override
    public Product findProduct(String productid) {
        Product product = null;
        for(Product p: products){
            if(p.getProductid().equals(productid)){
                product = p;
                break;
            }
        }
        return product;
    }

    @Override
    public List<Product> AllProducts() {
        return products;
    }
    
    
}
