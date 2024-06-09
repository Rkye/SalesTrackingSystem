package com.example.demo.mapper1;

import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.controller.sale.request.CreateSaleRequest;
import com.example.demo.controller.sale.request.UpdateSaleRequest;
import com.example.demo.controller.sale.response.SaleResponse;
import com.example.demo.controller.user.customer.response.CustomerResponse;
import com.example.demo.repository.product.Product;
import com.example.demo.repository.sale.Sale;
import com.example.demo.repository.user.customer.Customer;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.user.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleMapper {

    private final CustomerService customerService;
    private final ProductService productService;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    public  Sale toEntity(CreateSaleRequest request){
        if(request == null){
            return null;
        }

        CustomerResponse customerResponse = customerService.getById(request.getCustomerId());
        ProductResponse productResponse = productService.getById(request.getProductId());

        if (customerResponse == null || productResponse == null) {
            return null;
        }

        Customer customer =  customerMapper.toEntity(customerService.getById(request.getCustomerId()));
        Product product = productMapper.toEntity(productService.getById(request.getProductId()));

        return Sale.builder()
                .customer(customer)
                .product(product)
                .quantity(request.getQuantity())
                //.totalAmount(request.getTotalAmount())
                .saleDate(request.getSaleDate())
                .build();
    }

    public static SaleResponse toResponse(Sale sale){
        if(sale == null){
            return null;
        }

        return SaleResponse.builder()
                .customerId(sale.getCustomer().getId())
                .productId(sale.getCustomer().getId())
                .quantity(sale.getQuantity())
                .totalAmount(sale.getTotalAmount())
                .saleDate(sale.getSaleDate())
                .build();
    }

    public Sale toEntity(UpdateSaleRequest request, Sale existingSale) {
        if (request == null || existingSale == null) {
            return null;
        }

        Customer customer = customerMapper.toEntity(customerService.getById(request.getCustomerId()));
        Product product = productMapper.toEntity(productService.getById(request.getProductId()));

        return Sale.builder()
                .id(existingSale.getId())
                .customer(customer)
                .product(product)
                .quantity(request.getQuantity() != 0 ? request.getQuantity() : existingSale.getQuantity())
                //.totalAmount(request.getTotalAmount() != 0 ? request.getTotalAmount() : existingSale.getTotalAmount())
                .saleDate(request.getSaleDate() != null ? request.getSaleDate() : existingSale.getSaleDate())
                .build();
    }

}
