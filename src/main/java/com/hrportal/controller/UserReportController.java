package com.hrportal.controller;

import com.hrportal.model.UserReport;
import com.hrportal.service.IUserReportService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pardha Saradhi Mavilla
 */
@RestController
@RequestMapping("/userReport")
public class UserReportController {

    @Autowired
    private IUserReportService userReportService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userReportService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userReportService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserReport insert(@RequestBody UserReport userReport) {
        return userReportService.save(userReport);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserReport> update(@PathVariable("id") Long id, @RequestBody UserReport userReport) {
        try {
            return ResponseEntity.ok(userReportService.update(id, userReport));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserReport> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userReportService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
