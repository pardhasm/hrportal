package com.hrportal.service;

import com.hrportal.model.EmployeeOvertime;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeOvertimeService {

    List<EmployeeOvertime> getAll();

    EmployeeOvertime get(Long id) throws NotFoundException;

    EmployeeOvertime save(EmployeeOvertime employeeOvertime);

    EmployeeOvertime update(Long id, EmployeeOvertime employeeOvertime) throws NotFoundException;

    EmployeeOvertime delete(Long id) throws NotFoundException;
}
