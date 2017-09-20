package com.hrportal.controller;

import com.hrportal.model.EmployeeLeaveLog;
import com.hrportal.service.IEmployeeLeaveLogService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */

@RestController
@RequestMapping("/employeeLeaveLog")
public class EmployeeLeaveLogController {

    @Autowired
    private IEmployeeLeaveLogService employeeLeaveLogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeLeaveLogService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveLogService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeLeaveLog insert(@RequestBody EmployeeLeaveLog employeeLeaveLog) {
        return employeeLeaveLogService.save(employeeLeaveLog);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeLeaveLog> update(@PathVariable("id") Long id, @RequestBody EmployeeLeaveLog employeeLeaveLog) {
        try {
            return ResponseEntity.ok(employeeLeaveLogService.update(id, employeeLeaveLog));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeLeaveLog> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveLogService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
