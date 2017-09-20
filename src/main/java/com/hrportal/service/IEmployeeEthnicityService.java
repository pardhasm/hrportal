package com.hrportal.service;

import com.hrportal.model.EmployeeEthnicity;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeEthnicityService {

    List<EmployeeEthnicity> getAll();

    EmployeeEthnicity get(Long id) throws NotFoundException;

    EmployeeEthnicity save(EmployeeEthnicity employeeEthnicity);

    EmployeeEthnicity update(Long id, EmployeeEthnicity employeeEthnicity) throws NotFoundException;

    EmployeeEthnicity delete(Long id) throws NotFoundException;
}
