package com.example.storeApi.controller;

import com.example.storeApi.model.Employee;
import com.example.storeApi.model.Product;
import com.example.storeApi.service.EmployeeService;
import com.example.storeApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PatchMapping("/{id}/price")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestParam String name,
                                   @RequestParam String role,
                                   @RequestParam String gender,
                                   @RequestParam Integer age) {
        return employeeService.updateEmployee(id, name, role, gender, age);
    }
}
