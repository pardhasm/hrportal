package com.hrportal.service;

import com.hrportal.model.EmployeeLeave;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeLeaveService {

    List<EmployeeLeave> getAll();

    EmployeeLeave get(Long id) throws NotFoundException;

    EmployeeLeave save(EmployeeLeave employeeLeave);

    EmployeeLeave update(Long id, EmployeeLeave employeeLeave) throws NotFoundException;

    EmployeeLeave delete(Long id) throws NotFoundException;
}
