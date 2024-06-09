package com.example.demo.controller.sale.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleResponse {

    private int customerId;

    private int productId;

    private int quantity;

    private double totalAmount;

    private LocalDate saleDate;

}
