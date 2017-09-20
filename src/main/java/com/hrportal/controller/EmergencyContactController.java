package com.hrportal.controller;

import com.hrportal.model.EmergencyContact;
import com.hrportal.service.IEmergencyContactService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@RestController
@RequestMapping("/emergencyContact")
public class EmergencyContactController {

    @Autowired
    private IEmergencyContactService emergencyContactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(emergencyContactService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(emergencyContactService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmergencyContact insert(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.save(emergencyContact);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmergencyContact> update(@PathVariable("id") Long id, @RequestBody EmergencyContact emergencyContact) {
        try {
            return ResponseEntity.ok(emergencyContactService.update(id, emergencyContact));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmergencyContact> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(emergencyContactService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
