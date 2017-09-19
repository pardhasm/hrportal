package com.hrportal.controller;

import com.hrportal.model.Candidate;
import com.hrportal.service.ICandidateService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private ICandidateService candidateService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(candidateService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(candidateService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Candidate insert(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Candidate> Update(@PathVariable("id") Long id, @RequestBody Candidate candidate) {
        try {
            return ResponseEntity.ok(candidateService.update(id, candidate));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Candidate> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(candidateService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
