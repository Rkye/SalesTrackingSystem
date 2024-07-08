package com.example.demo.controller.product;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.TResponse;
import com.example.demo.controller.product.request.CreateProductRequest;
import com.example.demo.controller.product.request.UpdateProductRequest;
import com.example.demo.controller.product.response.ProductResponse;
import com.example.demo.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody @Valid CreateProductRequest createCarRequest){
        productService.create(createCarRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid UpdateProductRequest productRequest){
        productService.update(productRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TResponse<ProductResponse>> getById(@PathVariable int id){
        ProductResponse response = productService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TResponse<List<ProductResponse>>> getAll(){
        List<ProductResponse> responses = productService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        productService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }

}
