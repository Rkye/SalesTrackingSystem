package com.example.demo.service.user.customer;

import com.example.demo.controller.user.customer.request.CreateCustomerRequest;
import com.example.demo.controller.user.customer.request.UpdateCustomerRequest;
import com.example.demo.controller.user.customer.response.CustomerResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.user.customer.Customer;
import com.example.demo.repository.user.customer.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateCustomerRequest customerRequest) {

        Customer customer = mapperService.forRequest().map(customerRequest, Customer.class);
        customerRepository.save(customer);

    }

    public void update(UpdateCustomerRequest customerRequest){

        Customer existingCustomer = customerRepository.findById(customerRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Müşteri bulunamadı: " + customerRequest.getId()));

        mapperService.forRequest().map(customerRequest, existingCustomer);
        customerRepository.save(existingCustomer);

    }



    @Override
    public CustomerResponse getById(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Müşteri bulunamadı: " + id));
        return mapperService.forResponse().map(customer, CustomerResponse.class);

    }

    @Override
    public List<CustomerResponse> getAll() {

        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> mapperService.forResponse()
                .map(customer, CustomerResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {

        customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Müşteri bulunamadı: " + id));
        customerRepository.deleteById(id);

    }
}
