package com.hrportal.service;

import com.hrportal.model.EmployeeEducation;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IEmployeeEducationService {

    List<EmployeeEducation> getAll();

    EmployeeEducation get(Long id) throws NotFoundException;

    EmployeeEducation save(EmployeeEducation employeeEducation);

    EmployeeEducation update(Long id, EmployeeEducation employeeEducation) throws NotFoundException;

    EmployeeEducation delete(Long id) throws NotFoundException;
}
