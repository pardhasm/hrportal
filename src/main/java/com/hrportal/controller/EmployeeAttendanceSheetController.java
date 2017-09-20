package com.hrportal.controller;

import com.hrportal.model.EmployeeAttendanceSheet;
import com.hrportal.service.IEmployeeAttendanceSheetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeAttendanceSheet")
public class EmployeeAttendanceSheetController {

    @Autowired
    private IEmployeeAttendanceSheetService employeeAttendanceSheetService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeAttendanceSheetService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeAttendanceSheetService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeAttendanceSheet insert(@RequestBody EmployeeAttendanceSheet employeeAttendanceSheet) {
        return employeeAttendanceSheetService.save(employeeAttendanceSheet);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeAttendanceSheet> update(@PathVariable("id") Long id, @RequestBody EmployeeAttendanceSheet employeeAttendanceSheet) {
        try {
            return ResponseEntity.ok(employeeAttendanceSheetService.update(id, employeeAttendanceSheet));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeAttendanceSheet> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeAttendanceSheetService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
