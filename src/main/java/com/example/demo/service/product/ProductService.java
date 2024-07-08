package com.example.demo.service.product;

import com.example.demo.controller.product.request.CreateProductRequest;
import com.example.demo.controller.product.request.UpdateProductRequest;
import com.example.demo.controller.product.response.ProductResponse;

import java.util.List;

public interface ProductService {

    void create(CreateProductRequest productRequest);

    void update(UpdateProductRequest productRequest);

    ProductResponse getById(int id);

    List<ProductResponse> getAll();

    void delete(int id);

    boolean existsByName(String name);



}
