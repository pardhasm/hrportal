package com.hrportal.service;

import com.hrportal.model.EmployeeAttendanceSheet;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeAttendanceSheetService {

    List<EmployeeAttendanceSheet> getAll();

    EmployeeAttendanceSheet get(Long id) throws NotFoundException;

    EmployeeAttendanceSheet save(EmployeeAttendanceSheet employeeAttendanceSheet);

    EmployeeAttendanceSheet update(Long id, EmployeeAttendanceSheet employeeAttendanceSheet) throws NotFoundException;

    EmployeeAttendanceSheet delete(Long id) throws NotFoundException;
}
