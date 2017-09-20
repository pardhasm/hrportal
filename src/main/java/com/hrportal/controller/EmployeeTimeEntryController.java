package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmployeeTimeEntry;
import com.hrportal.service.IEmployeeTimeEntryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeTimeEntry")
public class EmployeeTimeEntryController {

    @Autowired
    private IEmployeeTimeEntryService employeeTimeEntryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeTimeEntryService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTimeEntryService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeTimeEntry insert(@RequestBody EmployeeTimeEntry employeeTimeEntry) {
        return employeeTimeEntryService.save(employeeTimeEntry);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeTimeEntry> update(@PathVariable("id") Long id, @RequestBody EmployeeTimeEntry employeeTimeEntry) {
        try {
            return ResponseEntity.ok(employeeTimeEntryService.update(id, employeeTimeEntry));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeTimeEntry> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeTimeEntryService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
