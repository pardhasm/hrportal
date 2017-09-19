package com.hrportal.controller;

import com.hrportal.model.Interview;
import com.hrportal.service.IInterviewService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RestController
@RequestMapping("/interview")
public class InterviewController {

    private IInterviewService interviewService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllInterviews() {
        return ResponseEntity.ok(interviewService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCallDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(interviewService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Interview insertCall(@RequestBody Interview interview) {
        return interviewService.save(interview);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Interview> UpdateCall(@PathVariable("id") Long id, @RequestBody Interview interview) {
        try {
            return ResponseEntity.ok(interviewService.update(id, interview));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Interview> UpdateCall(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(interviewService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
