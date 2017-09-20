package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmployeeTrainingSession;
import com.hrportal.service.IEmployeeTrainingSessionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeTrainingSession")
public class EmployeeTrainingSessionController {

    @Autowired
    private IEmployeeTrainingSessionService employeeTrainingSessionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeTrainingSessionService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTrainingSessionService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeTrainingSession insert(@RequestBody EmployeeTrainingSession employeeTrainingSession) {
        return employeeTrainingSessionService.save(employeeTrainingSession);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeTrainingSession> update(@PathVariable("id") Long id, @RequestBody EmployeeTrainingSession employeeTrainingSession) {
        try {
            return ResponseEntity.ok(employeeTrainingSessionService.update(id, employeeTrainingSession));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeTrainingSession> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTrainingSessionService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
