package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone",5000),
            new Product(102,"Canon Camera",70000),
            new Product(103,"Shure Mic",4000)
    ));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int productId){
        Product product = products.stream()
                .filter(prod -> prod.getProdId() == productId)
                .findFirst()
                .orElse(null);
        return product;
    }

    public Product addProduct(Product product){
        products.add(product);
        return product;
    }

    public Product updateProduct(Product product, Integer id){
        Product searchProduct = products.stream()
                .filter(prod -> prod.getProdId() == id)
                .findFirst()
                .orElse(null);

        if(!product.getProdName().isEmpty()){
            searchProduct.setProdName(product.getProdName());
        }
        if( product.getPrice() != null){
            searchProduct.setPrice(product.getPrice());
        }

        return searchProduct;
    }

    public String deleteProduct(Integer id){
        int index = 0;
        for(int i = 0; i < products.size();i++){
            if(products.get(i).getProdId() == id){
                index = i;
                break;
            }
        }
        products.remove(index);

        return "Product deleted";
    }
}
