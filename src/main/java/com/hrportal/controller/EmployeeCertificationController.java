package com.hrportal.controller;

import com.hrportal.model.EmployeeCertification;
import com.hrportal.service.IEmployeeCertificationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/employeeCertification")
public class EmployeeCertificationController {

    @Autowired
    private IEmployeeCertificationService employeeCertificationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeCertificationService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeCertificationService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeCertification insert(@RequestBody EmployeeCertification employeeCertification) {
        return employeeCertificationService.save(employeeCertification);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeCertification> update(@PathVariable("id") Long id, @RequestBody EmployeeCertification employeeCertification) {
        try {
            return ResponseEntity.ok(employeeCertificationService.update(id, employeeCertification));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeCertification> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeCertificationService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
