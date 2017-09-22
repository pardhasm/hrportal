package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.LeavePeriod;
import com.hrportal.service.ILeavePeriodService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leavePeriod")
public class LeavePeriodController {

    @Autowired
    private ILeavePeriodService leavePeriodService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(leavePeriodService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leavePeriodService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LeavePeriod insert(@RequestBody LeavePeriod leavePeriod) {
        return leavePeriodService.save(leavePeriod);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LeavePeriod> update(@PathVariable("id") Long id, @RequestBody LeavePeriod leavePeriod) {
        try {
            return ResponseEntity.ok(leavePeriodService.update(id, leavePeriod));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LeavePeriod> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leavePeriodService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
