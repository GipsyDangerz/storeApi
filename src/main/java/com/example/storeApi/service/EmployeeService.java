package com.example.storeApi.service;

import com.example.storeApi.model.Employee;
import com.example.storeApi.model.Product;
import com.example.storeApi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee employeeData) {
        Employee employee = findById(id);
        employee.setName(employeeData.getName());
        employee.setAge(employeeData.getAge());
        employee.setRole(employeeData.getRole());
        employee.setGender(employeeData.getGender());
        return employeeRepository.save(employee);
    }
}
