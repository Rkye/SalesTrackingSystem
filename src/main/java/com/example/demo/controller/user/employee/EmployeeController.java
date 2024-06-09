package com.example.demo.controller.user.employee;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.request.UpdateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.service.user.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void create(CreateEmployeeRequest employeeRequest) {

        employeeService.create(employeeRequest);

    }

    @PutMapping
    public void update(UpdateEmployeeRequest employeeRequest) {

        employeeService.update(employeeRequest);

    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@RequestParam int id) {

        return employeeService.getById(id);

    }

    @GetMapping
    public List<EmployeeResponse> getAll(){

        return employeeService.getAll();

    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam int id){

        employeeService.delete(id);

    }

}