package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.FieldNameMapping;
import com.hrportal.service.IFieldNameMappingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fieldNameMapping")
public class FieldNameMappingController {

    @Autowired
    private IFieldNameMappingService fieldNameMappingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(fieldNameMappingService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(fieldNameMappingService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public FieldNameMapping insert(@RequestBody FieldNameMapping fieldNameMapping) {
        return fieldNameMappingService.save(fieldNameMapping);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FieldNameMapping> update(@PathVariable("id") Long id, @RequestBody FieldNameMapping fieldNameMapping) {
        try {
            return ResponseEntity.ok(fieldNameMappingService.update(id, fieldNameMapping));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FieldNameMapping> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(fieldNameMappingService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
