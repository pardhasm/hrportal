package com.hrportal.controller;

import com.hrportal.model.SalaryComponent;
import com.hrportal.service.ISalaryComponentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/salaryComponent")
public class SalaryComponentController {

    @Autowired
    private ISalaryComponentService salaryComponentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(salaryComponentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(salaryComponentService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public SalaryComponent insert(@RequestBody SalaryComponent salaryComponent) {
        return salaryComponentService.save(salaryComponent);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalaryComponent> update(@PathVariable("id") Long id, @RequestBody SalaryComponent salaryComponent) {
        try {
            return ResponseEntity.ok(salaryComponentService.update(id, salaryComponent));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SalaryComponent> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(salaryComponentService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
