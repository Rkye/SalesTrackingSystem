package com.example.demo.controller.sale;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.TResponse;
import com.example.demo.controller.sale.request.CreateSaleRequest;
import com.example.demo.controller.sale.request.UpdateSaleRequest;
import com.example.demo.controller.sale.response.SaleResponse;
import com.example.demo.service.sale.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController extends BaseController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateSaleRequest saleRequest){

        saleService.create(saleRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateSaleRequest saleRequest){

        saleService.update(saleRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TResponse<SaleResponse>> getById(@RequestParam int id){

        SaleResponse response = saleService.getById(id);
        return answer(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<TResponse<List<SaleResponse>>> getAll(){

        List<SaleResponse> responses =  saleService.getAll();
        return answer(responses, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam int id){

        saleService.delete(id);
        return answer(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/between-dates")
    public ResponseEntity<TResponse<List<SaleResponse>>> getAllBySaleDateBetween(@RequestParam ("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                      @RequestParam ("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        List<SaleResponse> responses = saleService.findAllBySaleDateBetween(startDate, endDate);
        return answer(responses, HttpStatus.OK);
    }

}
