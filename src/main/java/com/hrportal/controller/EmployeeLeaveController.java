package com.hrportal.controller;

import com.hrportal.model.EmployeeLeave;
import com.hrportal.service.IEmployeeLeaveService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeLeave")
public class EmployeeLeaveController {

    @Autowired
    private IEmployeeLeaveService employeeLeaveService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeLeaveService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeLeave insert(@RequestBody EmployeeLeave employeeLeave) {
        return employeeLeaveService.save(employeeLeave);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeLeave> update(@PathVariable("id") Long id, @RequestBody EmployeeLeave employeeLeave) {
        try {
            return ResponseEntity.ok(employeeLeaveService.update(id, employeeLeave));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeLeave> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
