package com.saumik.employeemanagement.mapper;

import com.saumik.employeemanagement.dto.EmployeeDTO;
import com.saumik.employeemanagement.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO dto) {
        return new Employee(dto.getName(), dto.getEmail(), dto.getDepartment(), dto.getSalary(), dto.getJoiningDate());
    }

    public static Employee toEntityWithId(EmployeeDTO dto) {
        return new Employee(dto.getId(), dto.getName(), dto.getEmail(), dto.getDepartment(), dto.getSalary(), dto.getJoiningDate());
    }

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment(), employee.getSalary(), employee.getJoiningDate());
    }
}
