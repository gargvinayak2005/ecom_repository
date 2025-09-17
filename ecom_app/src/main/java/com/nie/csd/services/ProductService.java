package com.nie.csd.services;

import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.Exceptions.GeneralExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Products> getAllProducts() {
        return repository.findAll();
    }


    public Optional<Products> getProductById(String id) {
        Optional<Products> product = repository.findById(id);
        if (product.isEmpty()) {
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        return product;
    }

    public Products addProduct(Products product) {
        return repository.save(product);
    }


    public Products updateProduct(String id, Products product) {
        if (!repository.existsById(id)) {
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        product.setId(id);
        return repository.save(product);
    }

    public void deleteProduct(String id) {
        if (!repository.existsById(id)) {
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }
}