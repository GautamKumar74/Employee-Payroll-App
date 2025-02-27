package com.bridgelabz.employeepayrollapp.model;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;

    private String name;
    private double salary;

    // Constructors
    public Employee() {}

    // Constructor used for In-Memory Storage
    public Employee(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // (Optional) Constructor using DTO
    public Employee(Long id, EmployeeDTO dto) {
        this.id = id; // ID comes from service layer
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
