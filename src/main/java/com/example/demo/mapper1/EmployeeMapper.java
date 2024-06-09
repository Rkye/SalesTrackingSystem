package com.example.demo.mapper1;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.repository.user.employee.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static Employee toEntity(CreateEmployeeRequest request){
        if(request == null){
            return null;
        }

        return Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .build();
    }

    public static EmployeeResponse toResponse(Employee employee){
        if(employee == null){
            return null;
        }

        return EmployeeResponse.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .build();
    }
}
