package com.example.demo.service.user.employee;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.request.UpdateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.user.employee.Employee;
import com.example.demo.repository.user.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.core.exception.type.NotFoundExceptionType.EMPLOYEE_DATA_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class EmployeeManager implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateEmployeeRequest employeeRequest) {

        Employee employee = mapperService.forRequest().map(employeeRequest, Employee.class);
        employeeRepository.save(employee);

    }

    @Override
    public void update(UpdateEmployeeRequest employeeRequest) {

        Employee existingEmployee = employeeRepository.findById(employeeRequest.getId())
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_DATA_NOT_FOUND));

        mapperService.forRequest().map(employeeRequest, existingEmployee);
        employeeRepository.save(existingEmployee);

    }

    @Override
    public EmployeeResponse getById(int id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(EMPLOYEE_DATA_NOT_FOUND));
        return mapperService.forResponse().map(employee, EmployeeResponse.class);

    }

    @Override
    public List<EmployeeResponse> getAll() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> mapperService.forResponse()
                .map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {

        employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(EMPLOYEE_DATA_NOT_FOUND));
        employeeRepository.deleteById(id);

    }
}
