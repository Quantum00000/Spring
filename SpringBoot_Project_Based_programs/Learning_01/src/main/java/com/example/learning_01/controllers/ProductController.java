package com.example.learning_01.controllers;

import com.example.learning_01.entites.Product;
import com.example.learning_01.services.ProductServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    @PostMapping()
    public Product createProduct(@Valid @RequestBody Product product){
        return productServices.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product){
        return productServices.updateProduct(id,product);
    }

    @GetMapping()
    public List<Product> getProduct(){
        return productServices.getProduct();
    }

    @GetMapping("/{id}")
    public Product getElementById(@PathVariable Long id){
        return productServices.getElementById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productServices.deleteProduct(id);
    }

}
