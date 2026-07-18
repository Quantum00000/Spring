package com.example.learning_01.services;

import com.example.learning_01.entites.Product;
import com.example.learning_01.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct( Long id, Product product){
        Product exsistingProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("product not found with id:"+id));

        exsistingProduct.setName(product.getName());
        exsistingProduct.setDescription(product.getDescription());
        exsistingProduct.setPrice(product.getPrice());
        exsistingProduct.setStockQuantity(product.getStockQuantity());

        return productRepository.save(exsistingProduct);
    }


    public List<Product> getProduct(){
        return productRepository.findAll();
    }


    public Product getElementById(Long id){
        return productRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Product not found, with id:"+id));
    }


    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
