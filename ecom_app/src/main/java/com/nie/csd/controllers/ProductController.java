package com.nie.csd.controllers;

import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping({"/api/products", "/products"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"", "/"})
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Products getProductById(@PathVariable String id) {
        // Will throw ProductNotFoundException if not found, handled by GlobalExceptionHandler
        return productService.getProductById(id).get();
    }

    @PostMapping({"", "/"})
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }


    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable String id, @RequestBody Products product) {
        // Will throw ProductNotFoundException if not found, handled by GlobalExceptionHandler
        return productService.updateProduct(id, product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        // Will throw ProductNotFoundException if not found, handled by GlobalExceptionHandler
        productService.deleteProduct(id);
    }
}
