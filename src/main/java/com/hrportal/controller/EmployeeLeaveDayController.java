package com.hrportal.controller;

import com.hrportal.model.EmployeeLeaveDay;
import com.hrportal.service.IEmployeeLeaveDayService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeLeaveDay")
public class EmployeeLeaveDayController {

    @Autowired
    private IEmployeeLeaveDayService employeeLeaveDayService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeLeaveDayService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveDayService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeLeaveDay insert(@RequestBody EmployeeLeaveDay employeeLeaveDay) {
        return employeeLeaveDayService.save(employeeLeaveDay);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeLeaveDay> update(@PathVariable("id") Long id, @RequestBody EmployeeLeaveDay employeeLeaveDay) {
        try {
            return ResponseEntity.ok(employeeLeaveDayService.update(id, employeeLeaveDay));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeLeaveDay> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeLeaveDayService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
