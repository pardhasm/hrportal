package com.hrportal.service;

import com.hrportal.model.EmployeeSkill;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IEmployeeSkillService {

    List<EmployeeSkill> getAll();

    EmployeeSkill get(Long id) throws NotFoundException;

    EmployeeSkill save(EmployeeSkill employeeSkill);

    EmployeeSkill update(Long id, EmployeeSkill employeeSkill) throws NotFoundException;

    EmployeeSkill delete(Long id) throws NotFoundException;
}
