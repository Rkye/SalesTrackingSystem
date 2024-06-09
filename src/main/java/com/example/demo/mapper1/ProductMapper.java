package com.example.demo.mapper1;

import com.example.demo.controller.product.request.CreateProductRequest;
import com.example.demo.controller.product.request.UpdateProductRequest;
import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.repository.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }

        return ProductResponse.builder()
                .name(product.getName())
                .detail(product.getDetail())
                .stockQuantity(product.getStockQuantity())
                .unitPrice(product.getUnitPrice())
                .build();
    }

    public static Product toEntity(UpdateProductRequest request, Product existingProduct){
        if(request == null || existingProduct == null ){
            return null;
        }

        return Product.builder()
                .id(existingProduct.getId())
                .name(request.getName() != null ? request.getName() : existingProduct.getName())
                .detail(request.getDetail() != null ? request.getDetail() : existingProduct.getDetail())
                .stockQuantity(request.getStockQuantity() != 0 ? request.getStockQuantity() : existingProduct.getStockQuantity())
                .unitPrice(request.getUnitPrice() != 0 ? request.getUnitPrice() :  existingProduct.getUnitPrice())
                .build();
    }

    public Product toEntity(CreateProductRequest request) {
        if (request == null) {
            return null;
        }

        return Product.builder()
                .name(request.getName())
                .detail(request.getDetail())
                .stockQuantity(request.getStockQuantity())
                .unitPrice(request.getUnitPrice())
                .build();
    }

    public static Product toEntity(ProductResponse response) {
        if (response == null) {
            return null;
        }

        return Product.builder()
                .name(response.getName())
                .detail(response.getDetail())
                .stockQuantity(response.getStockQuantity())
                .unitPrice(response.getUnitPrice())
                .build();
    }


}
