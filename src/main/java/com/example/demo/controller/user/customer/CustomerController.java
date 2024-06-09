package com.example.demo.controller.user.customer;

import com.example.demo.controller.user.customer.request.CreateCustomerRequest;
import com.example.demo.controller.user.customer.request.UpdateCustomerRequest;
import com.example.demo.controller.user.customer.response.CustomerResponse;
import com.example.demo.service.user.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void create(CreateCustomerRequest customerRequest){

        customerService.create(customerRequest);

    }

    @PutMapping
    public void update(UpdateCustomerRequest customerRequest){

        customerService.update(customerRequest);

    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@RequestParam int id){

        return customerService.getById(id);

    }

    @GetMapping
    public List<CustomerResponse> getAll(){

        return customerService.getAll();

    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam int id){

        customerService.delete(id);

    }

}
