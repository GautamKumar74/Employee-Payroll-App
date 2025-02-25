package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // GET all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return repository.findById(id);
    }

    // POST: Create a new employee using DTO
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return repository.save(employee);
    }

    // PUT: Update an employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return repository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(employeeDTO.getName());
                    existingEmployee.setSalary(employeeDTO.getSalary());
                    return repository.save(existingEmployee);
                }).orElse(null);
    }

    // DELETE: Delete an employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "Employee deleted successfully!";
    }
}
