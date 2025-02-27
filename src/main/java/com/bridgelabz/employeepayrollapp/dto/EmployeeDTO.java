package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates getters, setters, toString(), equals(), and hashCode()
@AllArgsConstructor  // Generates a constructor with all fields
@NoArgsConstructor  // Generates a default constructor
public class EmployeeDTO {
    private String name;
    private double salary;
}
