package com.telusko.simpleWebApp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    private Integer prodId;
    private String prodName;
    private Integer price;
}
