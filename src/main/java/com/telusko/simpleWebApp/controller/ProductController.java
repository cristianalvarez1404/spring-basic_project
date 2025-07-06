package com.telusko.simpleWebApp.controller;


import com.telusko.simpleWebApp.model.Product;
import com.telusko.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product prod){
        return productService.addProduct(prod);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product prod, @PathVariable Integer id){
        return productService.updateProduct(prod,id);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
