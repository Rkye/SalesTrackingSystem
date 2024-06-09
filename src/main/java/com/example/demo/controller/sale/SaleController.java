package com.example.demo.controller.sale;

import com.example.demo.controller.sale.request.CreateSaleRequest;
import com.example.demo.controller.sale.request.UpdateSaleRequest;
import com.example.demo.controller.sale.response.SaleResponse;
import com.example.demo.service.sale.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public void create(@RequestBody @Valid CreateSaleRequest saleRequest){

        saleService.create(saleRequest);

    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateSaleRequest saleRequest){

        saleService.update(saleRequest);

    }

    @GetMapping("/{id}")
    public SaleResponse getById(@RequestParam int id){

        return saleService.getById(id);
    }

    @GetMapping
    public List<SaleResponse> getAll(){

        return saleService.getAll();

    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam int id){

        saleService.delete(id);

    }

    @GetMapping("/between-dates")
    public List<SaleResponse> getAllBySaleDateBetween(@RequestParam ("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                      @RequestParam ("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        return saleService.findAllBySaleDateBetween(startDate, endDate);

    }
}
