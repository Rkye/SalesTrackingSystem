package com.example.demo.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findAllBySaleDateBetween(LocalDate startDate, LocalDate endDate);

}
