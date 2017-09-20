package com.hrportal.controller;

import com.hrportal.model.EmployeeDependent;
import com.hrportal.service.IEmployeeDependentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeDependent")
public class EmployeeDependentController {

    @Autowired
    private IEmployeeDependentService employeeDependentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeDependentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDependentService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeDependent insert(@RequestBody EmployeeDependent employeeDependent) {
        return employeeDependentService.save(employeeDependent);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDependent> update(@PathVariable("id") Long id, @RequestBody EmployeeDependent employeeDependent) {
        try {
            return ResponseEntity.ok(employeeDependentService.update(id, employeeDependent));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeDependent> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDependentService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
