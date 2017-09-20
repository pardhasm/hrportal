package com.hrportal.service;

import com.hrportal.model.EmployeeLeaveDay;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeLeaveDayService {

    List<EmployeeLeaveDay> getAll();

    EmployeeLeaveDay get(Long id) throws NotFoundException;

    EmployeeLeaveDay save(EmployeeLeaveDay employeeLeaveDay);

    EmployeeLeaveDay update(Long id, EmployeeLeaveDay employeeLeaveDay) throws NotFoundException;

    EmployeeLeaveDay delete(Long id) throws NotFoundException;
}
