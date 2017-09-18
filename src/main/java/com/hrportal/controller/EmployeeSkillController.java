package com.hrportal.controller;

import com.hrportal.model.EmployeeSkill;
import com.hrportal.service.IEmployeeSkillService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@RestController
@RequestMapping("/employeeSkill")
public class EmployeeSkillController {

    private IEmployeeSkillService employeeSkillService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity getAllEmployeeSkills() {
        return ResponseEntity.ok(employeeSkillService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeDetails(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeSkillService.get(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeeSkill insertCandidate(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.save(employeeSkill);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeSkill> UpdateCandidate(@PathVariable("id") Long id, @RequestBody EmployeeSkill employeeSkill) {
        try {
            return ResponseEntity.ok(employeeSkillService.update(id, employeeSkill));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeSkill> DeleteEmployeeSkill(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(employeeSkillService.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}