package com.saumik.employeemanagement.service.impl;

import com.saumik.employeemanagement.dto.EmployeeDTO;
import com.saumik.employeemanagement.entity.Employee;
import com.saumik.employeemanagement.exception.EmailAlreadyExistsException;
import com.saumik.employeemanagement.exception.EmployeeNotFoundException;
import com.saumik.employeemanagement.mapper.EmployeeMapper;
import com.saumik.employeemanagement.repository.EmployeeRepository;
import com.saumik.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);

        // Check if email is being changed and already exists for another employee
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (existingEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email " + employeeDTO.getEmail() + " is already in use");
        }

        employee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        return EmployeeMapper.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        // Check if email is being changed and already exists for another employee
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (existingEmployee.isPresent() && !existingEmployee.get().getId().equals(id)) {
            throw new EmailAlreadyExistsException("Email " + employeeDTO.getEmail() + " is already in use");
        }

        // Update fields
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        employee.setJoiningDate(employeeDTO.getJoiningDate());

        employee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(employee);
    }


    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
