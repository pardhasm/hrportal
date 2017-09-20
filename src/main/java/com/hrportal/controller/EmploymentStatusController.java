package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.EmploymentStatus;
import com.hrportal.service.IEmploymentStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employmentStatus")
public class EmploymentStatusController {

    @Autowired
    private IEmploymentStatusService employmentStatusService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employmentStatusService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employmentStatusService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmploymentStatus insert(@RequestBody EmploymentStatus employmentStatus) {
        return employmentStatusService.save(employmentStatus);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmploymentStatus> update(@PathVariable("id") Long id, @RequestBody EmploymentStatus employmentStatus) {
        try {
            return ResponseEntity.ok(employmentStatusService.update(id, employmentStatus));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmploymentStatus> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employmentStatusService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
