package com.example.demo.service.sale;

import com.example.demo.controller.sale.request.CreateSaleRequest;
import com.example.demo.controller.sale.request.UpdateSaleRequest;
import com.example.demo.controller.sale.response.SaleResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.product.Product;
import com.example.demo.repository.product.ProductRepository;
import com.example.demo.repository.sale.Sale;
import com.example.demo.repository.sale.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaleManager implements SaleService{

    private final SaleRepository repository;
    private final ModelMapperService mapperService;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void create(CreateSaleRequest saleRequest) {

        Sale sale = mapperService.forRequest().map(saleRequest, Sale.class);

        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı: " + sale.getProduct().getId()));

        if (product.getStockQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Yetersiz stok: " + product.getName());
        }

        double totalAmount = calculateTotalAmount(sale);
        sale.setTotalAmount(totalAmount);

        product.setStockQuantity(product.getStockQuantity() - sale.getQuantity());

        productRepository.save(product);


        repository.save(sale);

    }

    @Override
    @Transactional
    public void update(UpdateSaleRequest saleRequest) {

        Sale existingSale = repository.findById(saleRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Satış bulunamadı: " + saleRequest.getId()));

        Product product = productRepository.findById(existingSale.getProduct().getId())
                .orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı: " + existingSale.getProduct().getId()));


        // Eski quantity değerini al
        int oldQuantity = existingSale.getQuantity();

       // Yeni quantity değerini güncelle
        existingSale.setQuantity(saleRequest.getQuantity());
        int newQuantity = existingSale.getQuantity();


        // Eğer yeni miktar eski miktardan küçükse stok geri eklenir, büyükse stok düşülür
        int quantityDifference = newQuantity - oldQuantity;

        if (product.getStockQuantity() < quantityDifference) {
            throw new RuntimeException("Yetersiz stok: " + product.getName());
        }

        product.setStockQuantity(product.getStockQuantity() - quantityDifference);

        mapperService.forRequest().map(saleRequest, existingSale);
        double totalAmount = calculateTotalAmount(existingSale);
        existingSale.setTotalAmount(totalAmount);
        productRepository.save(product);

        repository.save(existingSale);

    }

    @Override
    public SaleResponse getById(int id) {

        Sale sale = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Satış bulunamadı: " + id));
        SaleResponse saleResponse = mapperService.forResponse().map(sale, SaleResponse.class);
        return saleResponse;

    }

    @Override
    public List<SaleResponse> getAll() {

        List<Sale> sales = repository.findAll();
        return sales.stream()
                .map(sale -> mapperService.forResponse()
                .map(sale, SaleResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {

        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Satış bulunamadı: " + id));
        repository.deleteById(id);

    }

    public double calculateTotalAmount(Sale sale){

        double price = sale.getProduct().getUnitPrice();
        return price * sale.getQuantity();

    }

    @Override
    public List<SaleResponse> findAllBySaleDateBetween(LocalDate startDate, LocalDate endDate) {

        List<Sale> saleDates =  repository.findAllBySaleDateBetween(startDate, endDate);
        return saleDates.stream()
                        .map(sale -> mapperService.forResponse()
                        .map(sale, SaleResponse.class))
                        .collect(Collectors.toList());

    }

}
