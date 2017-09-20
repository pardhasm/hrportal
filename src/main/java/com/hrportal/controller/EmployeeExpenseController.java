package com.hrportal.controller;

import com.hrportal.model.EmployeeExpense;
import com.hrportal.service.IEmployeeExpenseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@RestController
@RequestMapping("/employeeExpense")
public class EmployeeExpenseController {

    @Autowired
    private IEmployeeExpenseService employeeExpenseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeExpenseService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeExpenseService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeExpense insert(@RequestBody EmployeeExpense employeeExpense) {
        return employeeExpenseService.save(employeeExpense);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeExpense> update(@PathVariable("id") Long id, @RequestBody EmployeeExpense employeeExpense) {
        try {
            return ResponseEntity.ok(employeeExpenseService.update(id, employeeExpense));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeExpense> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeExpenseService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
