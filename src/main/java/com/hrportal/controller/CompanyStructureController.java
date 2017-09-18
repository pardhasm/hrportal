package com.hrportal.controller;

import com.hrportal.model.CompanyStructure;
import com.hrportal.service.ICompanyStructureService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/companyStructure")
public class CompanyStructureController {

    private ICompanyStructureService companyStructureService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity getAllCompanyStructures() {
        return ResponseEntity.ok(companyStructureService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCompanyStructureDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(companyStructureService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CompanyStructure insertCompanyStructure(@RequestBody CompanyStructure companyStructure) {
        return companyStructureService.save(companyStructure);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompanyStructure> UpdateCompanyStructure(@PathVariable("id") Long id, @RequestBody CompanyStructure companyStructure) {
        try {
            return ResponseEntity.ok(companyStructureService.update(id, companyStructure));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CompanyStructure> DeleteCompanyStructure(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(companyStructureService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
