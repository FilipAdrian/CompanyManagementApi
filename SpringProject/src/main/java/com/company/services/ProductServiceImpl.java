package com.company.services;

import com.company.entities.Product;
import com.company.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getById(String id) {
        return productRepository.getById (id);
    }

    @Override
    public List <Product> getAll() {
        return productRepository.getAllBy ( );
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById (id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.save (product);
    }
}
