package com.example.demo.controller.product.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private String name;

    private String detail;

    private int stockQuantity;

    private double unitPrice;

}
