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

    public Employee updateEmployee(Long id, String name, String role, String gender, Integer age) {
        Employee employee = findById(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setRole(role);
        employee.setGender(gender);
        return employeeRepository.save(employee);
    }
}
