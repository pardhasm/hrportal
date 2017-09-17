package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.Call;
import com.hrportal.service.ICallService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/call")
public class CallController {

    private ICallService callService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllCalls() {
        return ResponseEntity.ok(callService.getAllCalls());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCallDetails(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(callService.getCall(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Call insertCall(@RequestBody Call call) {
        return callService.save(call);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Call> UpdateCall(@PathVariable("id") long id, @RequestBody Call call) {
        try {
            return ResponseEntity.ok(callService.updateCall(id, call));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
