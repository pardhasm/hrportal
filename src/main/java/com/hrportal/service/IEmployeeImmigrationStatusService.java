package com.hrportal.service;

import com.hrportal.model.EmployeeImmigrationStatus;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeImmigrationStatusService {

    List<EmployeeImmigrationStatus> getAll();

    EmployeeImmigrationStatus get(Long id) throws NotFoundException;

    EmployeeImmigrationStatus save(EmployeeImmigrationStatus employeeImmigrationStatus);

    EmployeeImmigrationStatus update(Long id, EmployeeImmigrationStatus employeeImmigrationStatus) throws NotFoundException;

    EmployeeImmigrationStatus delete(Long id) throws NotFoundException;
}
