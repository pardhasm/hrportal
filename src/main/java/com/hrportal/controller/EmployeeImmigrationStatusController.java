package com.hrportal.controller;

import com.hrportal.model.EmployeeImmigrationStatus;
import com.hrportal.service.IEmployeeImmigrationStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeImmigrationStatus")
public class EmployeeImmigrationStatusController {

    @Autowired
    private IEmployeeImmigrationStatusService employeeImmigrationStatusService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeImmigrationStatusService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeImmigrationStatusService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeImmigrationStatus insert(@RequestBody EmployeeImmigrationStatus employeeImmigrationStatus) {
        return employeeImmigrationStatusService.save(employeeImmigrationStatus);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeImmigrationStatus> update(@PathVariable("id") Long id, @RequestBody EmployeeImmigrationStatus employeeImmigrationStatus) {
        try {
            return ResponseEntity.ok(employeeImmigrationStatusService.update(id, employeeImmigrationStatus));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeImmigrationStatus> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeImmigrationStatusService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
