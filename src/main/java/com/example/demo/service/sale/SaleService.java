package com.example.demo.service.sale;

import com.example.demo.controller.sale.request.CreateSaleRequest;
import com.example.demo.controller.sale.request.UpdateSaleRequest;
import com.example.demo.controller.sale.response.SaleResponse;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    void create(CreateSaleRequest saleRequest);

    void update(UpdateSaleRequest saleRequest);

    SaleResponse getById(int id);

    List<SaleResponse> getAll();

    void delete(int id);

    List<SaleResponse> findAllBySaleDateBetween(LocalDate startDate, LocalDate endDate);
}
