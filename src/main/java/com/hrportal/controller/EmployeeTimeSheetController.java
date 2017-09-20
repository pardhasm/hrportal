package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmployeeTimeSheet;
import com.hrportal.service.IEmployeeTimeSheetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeTimeSheet")
public class EmployeeTimeSheetController {

    @Autowired
    private IEmployeeTimeSheetService employeeTimeSheetService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeTimeSheetService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTimeSheetService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeTimeSheet insert(@RequestBody EmployeeTimeSheet employeeTimeSheet) {
        return employeeTimeSheetService.save(employeeTimeSheet);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeTimeSheet> update(@PathVariable("id") Long id, @RequestBody EmployeeTimeSheet employeeTimeSheet) {
        try {
            return ResponseEntity.ok(employeeTimeSheetService.update(id, employeeTimeSheet));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeTimeSheet> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTimeSheetService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
