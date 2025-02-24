package com.saumik.employeemanagement.service;

import com.saumik.employeemanagement.entity.Employee;
import com.saumik.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
//        Long id = employee.getId();
//        if(employeeRepository.findById(id).isPresent()) {
//            return null;
//        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            // Update the existing employee's information here
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setDepartment(employee.getDepartment());
            updatedEmployee.setSalary(employee.getSalary());
            updatedEmployee.setJoiningDate(employee.getJoiningDate());

            // Save the updated employee
            return Optional.of(employeeRepository.save(updatedEmployee));
        } else {
            return Optional.empty();
        }
    }

}
