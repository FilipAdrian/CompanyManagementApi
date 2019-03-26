package com.company.controllers;

import com.company.entities.Product;
import com.company.exceptions.NotFoundException;
import com.company.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products")
    private ResponseEntity <List <Product>> displayAll() {
        List <Product> products = productService.getAll ( );

        return new ResponseEntity <> (products, HttpStatus.OK);
    }

    @PostMapping("/products")
    private ResponseEntity <?> save(@RequestBody Product product) {
        productService.saveOrUpdate (product);

        return new ResponseEntity <> (product, HttpStatus.CREATED);
    }

    @GetMapping("/products/{productId}")
    private ResponseEntity <Product> getById(@PathVariable("productId") String id) {
        Product product = productService.getById (id);
        if (product == null) {
            throw new NotFoundException ("product", id);
        }

        return new ResponseEntity <> (product, HttpStatus.OK);
    }

    @PutMapping("/products/{productId}")
    private ResponseEntity <?> update(@RequestBody Product product, @PathVariable("productId") String id) {
        Product currentProduct = productService.getById (id);
        if (currentProduct == null) {
            throw new NotFoundException ("product", id);
        }
        currentProduct.setName (product.getName ( ));
        currentProduct.setPrice (product.getPrice ( ));
        currentProduct.setManufacturer (product.getManufacturer ( ));
        currentProduct.setSubsidiary (product.getSubsidiary ( ));
        productService.saveOrUpdate (currentProduct);

        return new ResponseEntity <> (currentProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    private ResponseEntity <?> deleteById(@PathVariable("productId") String id) {
        Product product = productService.getById (id);
        if (product == null) {
            throw new NotFoundException ("product", id);
        }
        productService.deleteById (id);
        return new ResponseEntity <> (HttpStatus.NO_CONTENT);
    }
}
