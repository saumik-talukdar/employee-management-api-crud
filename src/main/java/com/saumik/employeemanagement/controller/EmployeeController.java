package com.saumik.employeemanagement.controller;

import com.saumik.employeemanagement.dto.EmployeeDTO;
import com.saumik.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // POST method for creating an employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        EmployeeDTO emp = service.createEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    // GET method for getting employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employee = service.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // GET method for getting all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = service.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // DELETE method for deleting employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);  // Assuming the delete method returns void
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // HTTP 204 No Content
    }

    // PUT method for updating employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = service.updateEmployee(id, employeeDTO);

        // Check if employee updated or not (though the service already throws exception if not found)
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee); // 200 OK with updated employee
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found if employee doesn't exist
        }
    }
}
