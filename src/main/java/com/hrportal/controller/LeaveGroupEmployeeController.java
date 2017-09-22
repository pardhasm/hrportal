package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.LeaveGroupEmployee;
import com.hrportal.service.ILeaveGroupEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaveGroupEmployee")
public class LeaveGroupEmployeeController {

    @Autowired
    private ILeaveGroupEmployeeService leaveGroupEmployeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(leaveGroupEmployeeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveGroupEmployeeService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LeaveGroupEmployee insert(@RequestBody LeaveGroupEmployee leaveGroupEmployee) {
        return leaveGroupEmployeeService.save(leaveGroupEmployee);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LeaveGroupEmployee> update(@PathVariable("id") Long id, @RequestBody LeaveGroupEmployee leaveGroupEmployee) {
        try {
            return ResponseEntity.ok(leaveGroupEmployeeService.update(id, leaveGroupEmployee));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LeaveGroupEmployee> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveGroupEmployeeService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
