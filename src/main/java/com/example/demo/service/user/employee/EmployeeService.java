package com.example.demo.service.user.employee;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.request.UpdateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    void create(CreateEmployeeRequest employeeRequest);

    void update(UpdateEmployeeRequest employeeRequest);

    EmployeeResponse getById(int id);

    List<EmployeeResponse> getAll();

    void delete(int id);

}
