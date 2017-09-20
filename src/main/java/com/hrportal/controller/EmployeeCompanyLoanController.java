package com.hrportal.controller;

import com.hrportal.model.EmployeeCompanyLoan;
import com.hrportal.service.IEmployeeCompanyLoanService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeCompanyLoan")
public class EmployeeCompanyLoanController {

    @Autowired
    private IEmployeeCompanyLoanService employeeCompanyLoanService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeCompanyLoanService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeCompanyLoanService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeCompanyLoan insert(@RequestBody EmployeeCompanyLoan employeeCompanyLoan) {
        return employeeCompanyLoanService.save(employeeCompanyLoan);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeCompanyLoan> update(@PathVariable("id") Long id, @RequestBody EmployeeCompanyLoan employeeCompanyLoan) {
        try {
            return ResponseEntity.ok(employeeCompanyLoanService.update(id, employeeCompanyLoan));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeCompanyLoan> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeCompanyLoanService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
