package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.LeaveStartingBalance;
import com.hrportal.service.ILeaveStartingBalanceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaveStartingBalance")
public class LeaveStartingBalanceController {

    @Autowired
    private ILeaveStartingBalanceService leaveStartingBalanceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(leaveStartingBalanceService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveStartingBalanceService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LeaveStartingBalance insert(@RequestBody LeaveStartingBalance leaveStartingBalance) {
        return leaveStartingBalanceService.save(leaveStartingBalance);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LeaveStartingBalance> update(@PathVariable("id") Long id, @RequestBody LeaveStartingBalance leaveStartingBalance) {
        try {
            return ResponseEntity.ok(leaveStartingBalanceService.update(id, leaveStartingBalance));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LeaveStartingBalance> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveStartingBalanceService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
