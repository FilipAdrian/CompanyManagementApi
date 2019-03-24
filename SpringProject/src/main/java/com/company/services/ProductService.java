package com.company.services;

import com.company.entities.Product;

import java.util.List;

public interface ProductService {
    Product getById(String id);

    List <Product> getAll();

    void deleteById(String id);

    void saveOrUpdate(Product product);
}
