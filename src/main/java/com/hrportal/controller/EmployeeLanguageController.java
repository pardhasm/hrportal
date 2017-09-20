package com.hrportal.controller;

import com.hrportal.model.EmployeeLanguage;
import com.hrportal.service.IEmployeeLanguageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeLanguage")
public class EmployeeLanguageController {

    @Autowired
    private IEmployeeLanguageService employeeLanguageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeLanguageService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLanguageService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeLanguage insert(@RequestBody EmployeeLanguage employeeLanguage) {
        return employeeLanguageService.save(employeeLanguage);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeLanguage> update(@PathVariable("id") Long id, @RequestBody EmployeeLanguage employeeLanguage) {
        try {
            return ResponseEntity.ok(employeeLanguageService.update(id, employeeLanguage));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeLanguage> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLanguageService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
