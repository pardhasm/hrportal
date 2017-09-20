package com.hrportal.service;

import com.hrportal.model.EmployeeDataHistory;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeDataHistoryService {

    List<EmployeeDataHistory> getAll();

    EmployeeDataHistory get(Long id) throws NotFoundException;

    EmployeeDataHistory save(EmployeeDataHistory employeeDataHistory);

    EmployeeDataHistory update(Long id, EmployeeDataHistory employeeDataHistory) throws NotFoundException;

    EmployeeDataHistory delete(Long id) throws NotFoundException;
}
