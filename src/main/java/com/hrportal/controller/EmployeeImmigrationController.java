package com.hrportal.controller;

import com.hrportal.model.EmployeeImmigration;
import com.hrportal.service.IEmployeeImmigrationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeImmigration")
public class EmployeeImmigrationController {

    @Autowired
    private IEmployeeImmigrationService employeeImmigrationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeImmigrationService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeImmigrationService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeImmigration insert(@RequestBody EmployeeImmigration employeeImmigration) {
        return employeeImmigrationService.save(employeeImmigration);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeImmigration> update(@PathVariable("id") Long id, @RequestBody EmployeeImmigration employeeImmigration) {
        try {
            return ResponseEntity.ok(employeeImmigrationService.update(id, employeeImmigration));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeImmigration> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeImmigrationService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
