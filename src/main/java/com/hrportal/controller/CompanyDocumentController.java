package com.hrportal.controller;

import com.hrportal.model.CompanyDocument;
import com.hrportal.service.ICompanyDocumentService;
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
@RequestMapping("/companyDocument")
public class CompanyDocumentController {

    @Autowired
    private ICompanyDocumentService companyDocumentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(companyDocumentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(companyDocumentService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CompanyDocument insert(@Valid @RequestBody CompanyDocument companyDocument) {
        return companyDocumentService.save(companyDocument);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompanyDocument> update(@PathVariable("id") Long id, @Valid @RequestBody CompanyDocument companyDocument) {
        try {
            return ResponseEntity.ok(companyDocumentService.update(id, companyDocument));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CompanyDocument> delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(companyDocumentService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
