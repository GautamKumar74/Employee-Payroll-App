package com.bridgelabz.employeepayrollapp.model;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;

    // Constructors
    public Employee() {}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // (Optional) Constructor using DTO
    public Employee(EmployeeDTO dto) {
        this.name = dto.getName();
        this.salary = dto.getSalary();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
