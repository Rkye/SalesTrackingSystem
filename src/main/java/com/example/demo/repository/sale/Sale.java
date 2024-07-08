package com.example.demo.repository.sale;

import com.example.demo.core.Base;
import com.example.demo.repository.product.Product;
import com.example.demo.repository.user.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale extends Base {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

}
