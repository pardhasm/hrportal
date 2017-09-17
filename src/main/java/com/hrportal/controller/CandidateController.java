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

    @RequestMapping(value="/all",method=RequestMethod.GET)
    public ResponseEntity getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCandidateDetails(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(candidateService.getCandidate(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Candidate insertCandidate(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Candidate> UpdateCandidate(@PathVariable("id") long id, @RequestBody Candidate candidate) {
        try {
            return ResponseEntity.ok(candidateService.updateCandidate(id, candidate));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
}
