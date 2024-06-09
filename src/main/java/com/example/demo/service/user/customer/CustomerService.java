package com.example.demo.service.user.customer;

import com.example.demo.controller.user.customer.request.CreateCustomerRequest;
import com.example.demo.controller.user.customer.request.UpdateCustomerRequest;
import com.example.demo.controller.user.customer.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    void create(CreateCustomerRequest customerRequest);

    void update(UpdateCustomerRequest customerRequest);

    CustomerResponse getById(int id);

    List<CustomerResponse> getAll();

    void delete(int id);

}
