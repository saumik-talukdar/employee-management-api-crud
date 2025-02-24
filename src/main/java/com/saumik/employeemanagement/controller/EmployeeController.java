package com.saumik.employeemanagement.controller;

import com.saumik.employeemanagement.entity.Employee;
import com.saumik.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee emp = service.save(employee);
//        if(emp == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = service.getEmployeeById(id);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = service.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> updatedEmployee = service.updateEmployee(id, employee);

        if (updatedEmployee.isPresent()) {
            return ResponseEntity.ok(updatedEmployee.get()); // 200 OK with updated employee
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found if employee doesn't exist
        }
    }


}
