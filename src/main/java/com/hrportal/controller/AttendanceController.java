package com.hrportal.controller;

import com.hrportal.model.Attendance;
import com.hrportal.service.IAttendanceService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private IAttendanceService attendanceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(attendanceService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(attendanceService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Attendance insert(@RequestBody Attendance attendance) {
        return attendanceService.save(attendance);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Attendance> update(@PathVariable("id") Long id, @RequestBody Attendance attendance) {
        try {
            return ResponseEntity.ok(attendanceService.update(id, attendance));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Attendance> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(attendanceService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
