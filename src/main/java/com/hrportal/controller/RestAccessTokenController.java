package com.hrportal.controller;

import com.hrportal.model.RestAccessToken;
import com.hrportal.service.IRestAccessTokenService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/restAccessToken")
public class RestAccessTokenController {

    @Autowired
    private IRestAccessTokenService restAccessTokenService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(restAccessTokenService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(restAccessTokenService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RestAccessToken insert(@RequestBody RestAccessToken restAccessToken) {
        return restAccessTokenService.save(restAccessToken);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RestAccessToken> update(@PathVariable("id") Long id, @RequestBody RestAccessToken restAccessToken) {
        try {
            return ResponseEntity.ok(restAccessTokenService.update(id, restAccessToken));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RestAccessToken> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(restAccessTokenService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
