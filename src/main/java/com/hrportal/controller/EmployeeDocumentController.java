package com.hrportal.controller;

import com.hrportal.model.EmployeeDocument;
import com.hrportal.service.IEmployeeDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeDocument")
public class EmployeeDocumentController {

    @Autowired
    private IEmployeeDocumentService employeeDocumentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeDocumentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDocumentService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeDocument insert(@RequestBody EmployeeDocument employeeDocument) {
        return employeeDocumentService.save(employeeDocument);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDocument> update(@PathVariable("id") Long id, @RequestBody EmployeeDocument employeeDocument) {
        try {
            return ResponseEntity.ok(employeeDocumentService.update(id, employeeDocument));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeDocument> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeDocumentService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
