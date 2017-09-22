package com.hrportal.controller;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */

import com.hrportal.model.ImmigrationDocument;
import com.hrportal.service.IImmigrationDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/immigrationDocument")
public class ImmigrationDocumentController {

    @Autowired
    private IImmigrationDocumentService immigrationDocumentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(immigrationDocumentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(immigrationDocumentService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ImmigrationDocument insert(@RequestBody ImmigrationDocument immigrationDocument) {
        return immigrationDocumentService.save(immigrationDocument);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ImmigrationDocument> update(@PathVariable("id") Long id, @RequestBody ImmigrationDocument immigrationDocument) {
        try {
            return ResponseEntity.ok(immigrationDocumentService.update(id, immigrationDocument));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ImmigrationDocument> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(immigrationDocumentService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
