package com.bridgelabz.employeepayrollapp.controller;

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

    // POST: Create a new employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    // PUT: Update an employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (repository.existsById(id)) {
            employee.setId(id);
            return repository.save(employee);
        }
        return null;
    }

    // DELETE: Delete an employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "Employee deleted successfully!";
    }
}
