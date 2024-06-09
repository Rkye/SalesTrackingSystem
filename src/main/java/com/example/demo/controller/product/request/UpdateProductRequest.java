package com.example.demo.controller.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String detail;

    @NotNull
    private int stockQuantity;

    @NotNull
    private double unitPrice;
}
