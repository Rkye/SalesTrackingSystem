package com.example.demo.repository.product;

import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.core.Base;
import com.example.demo.repository.sale.Sale;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "products")
public class Product extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    public ProductResponse toModel(){
        return ProductResponse.builder()
                .build();
    }

}
