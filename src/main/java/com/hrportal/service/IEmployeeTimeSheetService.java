package com.hrportal.service;

import com.hrportal.model.EmployeeTimeSheet;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeTimeSheetService {

    List<EmployeeTimeSheet> getAll();

    EmployeeTimeSheet get(Long id) throws NotFoundException;

    EmployeeTimeSheet save(EmployeeTimeSheet employeeTimeSheet);

    EmployeeTimeSheet update(Long id, EmployeeTimeSheet employeeTimeSheet) throws NotFoundException;

    EmployeeTimeSheet delete(Long id) throws NotFoundException;
}
