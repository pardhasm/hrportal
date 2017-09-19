package com.hrportal.controller;

import com.hrportal.model.CustomFieldValue;
import com.hrportal.service.ICustomFieldValueService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/customFieldValue")
public class CustomFieldValueController {

    private ICustomFieldValueService customFieldValueService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(customFieldValueService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(customFieldValueService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CustomFieldValue insert(@RequestBody CustomFieldValue customFieldValue) {
        return customFieldValueService.save(customFieldValue);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CustomFieldValue> update(@PathVariable("id") Long id, @RequestBody CustomFieldValue customFieldValue) {
        try {
            return ResponseEntity.ok(customFieldValueService.update(id, customFieldValue));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CustomFieldValue> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(customFieldValueService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
