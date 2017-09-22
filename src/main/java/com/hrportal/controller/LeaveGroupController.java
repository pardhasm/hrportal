package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.LeaveGroup;
import com.hrportal.service.ILeaveGroupService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaveGroup")
public class LeaveGroupController {

    @Autowired
    private ILeaveGroupService leaveGroupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(leaveGroupService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveGroupService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LeaveGroup insert(@RequestBody LeaveGroup leaveGroup) {
        return leaveGroupService.save(leaveGroup);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LeaveGroup> update(@PathVariable("id") Long id, @RequestBody LeaveGroup leaveGroup) {
        try {
            return ResponseEntity.ok(leaveGroupService.update(id, leaveGroup));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LeaveGroup> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(leaveGroupService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
