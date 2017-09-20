package com.hrportal.service;

import com.hrportal.model.EmployeeDependent;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeDependentService {

    List<EmployeeDependent> getAll();

    EmployeeDependent get(Long id) throws NotFoundException;

    EmployeeDependent save(EmployeeDependent employeeDependent);

    EmployeeDependent update(Long id, EmployeeDependent employeeDependent) throws NotFoundException;

    EmployeeDependent delete(Long id) throws NotFoundException;
}
