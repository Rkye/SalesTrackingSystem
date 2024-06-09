package com.example.demo.controller.product;

import com.example.demo.controller.product.request.CreateProductRequest;
import com.example.demo.controller.product.request.UpdateProductRequest;
import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody @Valid CreateProductRequest createCarRequest){
        productService.create(createCarRequest);
    }

    @PutMapping
    public void updateProduct(@RequestBody @Valid UpdateProductRequest productRequest){
        productService.update(productRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping
    public List<ProductResponse> getAll(){
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

}
