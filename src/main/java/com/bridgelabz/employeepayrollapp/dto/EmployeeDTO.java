package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data  // Generates getters, setters, toString(), equals(), and hashCode()
@AllArgsConstructor  // Generates a constructor with all fields
@NoArgsConstructor  // Generates a default constructor
public class EmployeeDTO implements Serializable {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]+$", message = "Name must start with a capital letter and contain only letters and spaces")
    private String name;
    private double salary;
}
