package com.example.demo.service.product;

import com.example.demo.controller.product.request.CreateProductRequest;
import com.example.demo.controller.product.request.UpdateProductRequest;
import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.mapper1.ProductMapper;
import com.example.demo.repository.product.Product;
import com.example.demo.repository.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService{

    private final ProductRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateProductRequest productRequest) {

        Product product = this.mapperService.forRequest().map(productRequest, Product.class);
        repository.save(product);

    }

    @Override
    public void update(UpdateProductRequest productRequest) {

        Product existingProduct = repository.findById(productRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı: " + productRequest.getId()));

        // Mevcut ürünü güncellemek için mapperService kullanarak yeni verilerle güncelle
        mapperService.forRequest().map(productRequest, existingProduct);
        repository.save(existingProduct);

    }


    @Override
    public ProductResponse getById(int id) {

        Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı: " + id));
        ProductResponse productResponse = mapperService.forResponse().map(product, ProductResponse.class);
        return productResponse;

    }

    @Override
    public List<ProductResponse> getAll() {

        List<Product> products = repository.findAll();
        return products.stream()
                .map(product -> this.mapperService
                        .forResponse()
                        .map(product, ProductResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {

        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı: " + id));
        repository.deleteById(id);

    }


}

