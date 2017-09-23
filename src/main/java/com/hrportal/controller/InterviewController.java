package com.hrportal.controller;

import com.hrportal.model.Interview;
import com.hrportal.service.IInterviewService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private IInterviewService interviewService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(interviewService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(interviewService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Interview insert(@Valid @RequestBody Interview interview) {
        return interviewService.save(interview);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Interview> update(@PathVariable("id") Long id, @Valid @RequestBody Interview interview) {
        try {
            return ResponseEntity.ok(interviewService.update(id, interview));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Interview> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(interviewService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
