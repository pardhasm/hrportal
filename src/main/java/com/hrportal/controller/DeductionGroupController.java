package com.hrportal.controller;

import com.hrportal.model.DeductionGroup;
import com.hrportal.service.IDeductionGroupService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/deductionGroup")
public class DeductionGroupController {

    @Autowired
    private IDeductionGroupService deductionGroupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(deductionGroupService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(deductionGroupService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public DeductionGroup insert(@RequestBody DeductionGroup deductionGroup) {
        return deductionGroupService.save(deductionGroup);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DeductionGroup> update(@PathVariable("id") Long id, @RequestBody DeductionGroup deductionGroup) {
        try {
            return ResponseEntity.ok(deductionGroupService.update(id, deductionGroup));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DeductionGroup> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(deductionGroupService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
