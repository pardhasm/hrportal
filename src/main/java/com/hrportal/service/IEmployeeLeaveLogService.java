package com.hrportal.service;

import com.hrportal.model.EmployeeLeaveLog;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeLeaveLogService {

    List<EmployeeLeaveLog> getAll();

    EmployeeLeaveLog get(Long id) throws NotFoundException;

    EmployeeLeaveLog save(EmployeeLeaveLog employeeLeaveLog);

    EmployeeLeaveLog update(Long id, EmployeeLeaveLog employeeLeaveLog) throws NotFoundException;

    EmployeeLeaveLog delete(Long id) throws NotFoundException;
}
