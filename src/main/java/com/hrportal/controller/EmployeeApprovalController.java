package com.hrportal.controller;

import com.hrportal.model.EmployeeApproval;
import com.hrportal.service.IEmployeeApprovalService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/employeeApproval")
public class EmployeeApprovalController {

    @Autowired
    private IEmployeeApprovalService employeeApprovalService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeApprovalService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeApprovalService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeApproval insert(@Valid @RequestBody EmployeeApproval employeeApproval) {
        return employeeApprovalService.save(employeeApproval);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeApproval> update(@PathVariable("id") Long id, @Valid @RequestBody EmployeeApproval employeeApproval) {
        try {
            return ResponseEntity.ok(employeeApprovalService.update(id, employeeApproval));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeApproval> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeApprovalService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
