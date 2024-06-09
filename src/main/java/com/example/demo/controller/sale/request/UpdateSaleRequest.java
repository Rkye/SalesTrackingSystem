package com.example.demo.controller.sale.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {

    @NotNull
    private int id;

    @NotNull
    private int customerId;

    @NotNull
    private int productId;

    @NotNull
    private int quantity;


    //private double totalAmount;

    @NotNull
    private LocalDate saleDate;

}
