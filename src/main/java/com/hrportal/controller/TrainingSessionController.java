package com.hrportal.controller;

import com.hrportal.model.TrainingSession;
import com.hrportal.service.ITrainingSessionService;
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
@RequestMapping("/trainingSession")
public class TrainingSessionController {

    @Autowired
    private ITrainingSessionService trainingSessionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(trainingSessionService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(trainingSessionService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TrainingSession insert(@Valid @RequestBody TrainingSession trainingSession) {
        return trainingSessionService.save(trainingSession);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TrainingSession> update(@PathVariable("id") Long id, @Valid @RequestBody TrainingSession trainingSession) {
        try {
            return ResponseEntity.ok(trainingSessionService.update(id, trainingSession));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TrainingSession> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(trainingSessionService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
