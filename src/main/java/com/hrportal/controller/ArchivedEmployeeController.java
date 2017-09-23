package com.hrportal.controller;

import com.hrportal.model.ArchivedEmployee;
import com.hrportal.service.IArchivedEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/archivedEmployee")
public class ArchivedEmployeeController {

    @Autowired
    private IArchivedEmployeeService archivedEmployeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(archivedEmployeeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(archivedEmployeeService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ArchivedEmployee insert(@Valid @RequestBody ArchivedEmployee archivedEmployee) {
        return archivedEmployeeService.save(archivedEmployee);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ArchivedEmployee> update(@PathVariable("id") Long id, @Valid @RequestBody ArchivedEmployee archivedEmployee) {
        try {
            return ResponseEntity.ok(archivedEmployeeService.update(id, archivedEmployee));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ArchivedEmployee> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(archivedEmployeeService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
