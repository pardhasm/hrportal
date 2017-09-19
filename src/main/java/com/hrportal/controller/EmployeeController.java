package com.hrportal.controller;

import com.hrportal.model.Call;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.update(id, employee));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> UpdateCall(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
