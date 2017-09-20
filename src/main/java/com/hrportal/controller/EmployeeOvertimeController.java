package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmployeeOvertime;
import com.hrportal.service.IEmployeeOvertimeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeOvertime")
public class EmployeeOvertimeController {

    @Autowired
    private IEmployeeOvertimeService employeeOvertimeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeOvertimeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeOvertimeService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeOvertime insert(@RequestBody EmployeeOvertime employeeOvertime) {
        return employeeOvertimeService.save(employeeOvertime);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeOvertime> update(@PathVariable("id") Long id, @RequestBody EmployeeOvertime employeeOvertime) {
        try {
            return ResponseEntity.ok(employeeOvertimeService.update(id, employeeOvertime));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeOvertime> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeOvertimeService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
