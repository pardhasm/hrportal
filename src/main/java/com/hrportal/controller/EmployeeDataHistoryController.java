package com.hrportal.controller;

import com.hrportal.model.EmployeeDataHistory;
import com.hrportal.service.IEmployeeDataHistoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeDataHistory")
public class EmployeeDataHistoryController {

    @Autowired
    private IEmployeeDataHistoryService employeeDataHistoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeDataHistoryService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDataHistoryService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeDataHistory insert(@RequestBody EmployeeDataHistory employeeDataHistory) {
        return employeeDataHistoryService.save(employeeDataHistory);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDataHistory> update(@PathVariable("id") Long id, @RequestBody EmployeeDataHistory employeeDataHistory) {
        try {
            return ResponseEntity.ok(employeeDataHistoryService.update(id, employeeDataHistory));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeDataHistory> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDataHistoryService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
