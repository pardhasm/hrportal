package com.hrportal.controller;

import com.hrportal.model.EmployeeEthnicity;
import com.hrportal.service.IEmployeeEthnicityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeEthnicity")
public class EmployeeEthnicityController {

    @Autowired
    private IEmployeeEthnicityService employeeEthnicityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeEthnicityService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeEthnicityService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeEthnicity insert(@RequestBody EmployeeEthnicity employeeEthnicity) {
        return employeeEthnicityService.save(employeeEthnicity);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeEthnicity> update(@PathVariable("id") Long id, @RequestBody EmployeeEthnicity employeeEthnicity) {
        try {
            return ResponseEntity.ok(employeeEthnicityService.update(id, employeeEthnicity));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeEthnicity> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeEthnicityService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
