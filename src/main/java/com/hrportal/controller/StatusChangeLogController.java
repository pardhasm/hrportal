package com.hrportal.controller;

import com.hrportal.model.StatusChangeLog;
import com.hrportal.service.IStatusChangeLogService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Pardha Saradhi Mavilla
 */
@RestController
@RequestMapping("/statusChangeLog")
public class StatusChangeLogController {

    @Autowired
    private IStatusChangeLogService statusChangeLogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(statusChangeLogService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(statusChangeLogService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public StatusChangeLog insert(@Valid @RequestBody StatusChangeLog statusChangeLog) {
        return statusChangeLogService.save(statusChangeLog);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StatusChangeLog> update(@PathVariable("id") Long id, @Valid @RequestBody StatusChangeLog statusChangeLog) {
        try {
            return ResponseEntity.ok(statusChangeLogService.update(id, statusChangeLog));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StatusChangeLog> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(statusChangeLogService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
