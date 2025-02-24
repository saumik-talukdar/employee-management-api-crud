package com.saumik.employeemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department;
    private Double salary;
    private LocalDate joiningDate;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee(Long id, String name, String email, String department, Double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public Employee(String name, String email, String department, Double salary, LocalDate joiningDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public Employee() {
    }
}
