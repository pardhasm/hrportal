package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmployeeTravelRecord;
import com.hrportal.service.IEmployeeTravelRecordService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeTravelRecord")
public class EmployeeTravelRecordController {

    @Autowired
    private IEmployeeTravelRecordService employeeTravelRecordService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeTravelRecordService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTravelRecordService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeTravelRecord insert(@RequestBody EmployeeTravelRecord employeeTravelRecord) {
        return employeeTravelRecordService.save(employeeTravelRecord);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeTravelRecord> update(@PathVariable("id") Long id, @RequestBody EmployeeTravelRecord employeeTravelRecord) {
        try {
            return ResponseEntity.ok(employeeTravelRecordService.update(id, employeeTravelRecord));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeTravelRecord> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTravelRecordService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
