package com.hrportal.controller;

import com.hrportal.model.PayrollEmployee;
import com.hrportal.service.IPayrollEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/payroll")
public class PayrollEmployeeController {

    @Autowired
    private IPayrollEmployeeService payrollEmployeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(payrollEmployeeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(payrollEmployeeService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PayrollEmployee insert(@Valid @RequestBody PayrollEmployee payrollEmployee) {
        return payrollEmployeeService.save(payrollEmployee);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PayrollEmployee> update(@PathVariable("id") Long id, @Valid @RequestBody PayrollEmployee payrollEmployee) {
        try {
            return ResponseEntity.ok(payrollEmployeeService.update(id, payrollEmployee));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PayrollEmployee> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(payrollEmployeeService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
