package com.hrportal.service;

import com.hrportal.model.EmployeeTimeEntry;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeTimeEntryService {

    List<EmployeeTimeEntry> getAll();

    EmployeeTimeEntry get(Long id) throws NotFoundException;

    EmployeeTimeEntry save(EmployeeTimeEntry employeeTimeEntry);

    EmployeeTimeEntry update(Long id, EmployeeTimeEntry employeeTimeEntry) throws NotFoundException;

    EmployeeTimeEntry delete(Long id) throws NotFoundException;
}
