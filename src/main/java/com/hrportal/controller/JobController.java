package com.hrportal.controller;

import com.hrportal.model.Job;
import com.hrportal.service.IJobService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

@RestController
@RequestMapping("/job")
public class JobController {

    private IJobService jobService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllJobs() {
        return ResponseEntity.ok(jobService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getJobDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(jobService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Job insertJob(@RequestBody Job job) {
        return jobService.save(job);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Job> UpdateJob(@PathVariable("id") Long id, @RequestBody Job job) {
        try {
            return ResponseEntity.ok(jobService.update(id, job));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Job> UpdateCall(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(jobService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
