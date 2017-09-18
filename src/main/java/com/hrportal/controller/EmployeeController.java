package com.hrportal.controller;

import com.hrportal.model.Employee;
import com.hrportal.service.IEmployeeService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private IEmployeeService employeeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeDetails(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
