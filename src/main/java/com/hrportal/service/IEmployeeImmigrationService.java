package com.hrportal.service;

import com.hrportal.model.EmployeeImmigration;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeImmigrationService {

    List<EmployeeImmigration> getAll();

    EmployeeImmigration get(Long id) throws NotFoundException;

    EmployeeImmigration save(EmployeeImmigration employeeImmigration);

    EmployeeImmigration update(Long id, EmployeeImmigration employeeImmigration) throws NotFoundException;

    EmployeeImmigration delete(Long id) throws NotFoundException;
}
