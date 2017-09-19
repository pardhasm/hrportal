package com.hrportal.controller;

import com.hrportal.model.EmployeeEducation;
import com.hrportal.service.IEmployeeEducationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/employeeEducation")
public class EmployeeEducationController {

    @Autowired
    private IEmployeeEducationService employeeEducationService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity getAllCandidates() {
        return ResponseEntity.ok(employeeEducationService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeEducationDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeEducationService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeEducation insertEmployeeEducation(@RequestBody EmployeeEducation employeeEducation) {
        return employeeEducationService.save(employeeEducation);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeEducation> UpdateEmployeeEducation(@PathVariable("id") Long id, @RequestBody EmployeeEducation employeeEducation) {
        try {
            return ResponseEntity.ok(employeeEducationService.update(id, employeeEducation));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeEducation> DeleteEmployeeEducation(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeEducationService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
