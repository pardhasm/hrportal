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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(callService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(callService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Call insert(@RequestBody Call call) {
        return callService.save(call);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Call> update(@PathVariable("id") Long id, @RequestBody Call call) {
        try {
            return ResponseEntity.ok(callService.update(id, call));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Call> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(callService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
