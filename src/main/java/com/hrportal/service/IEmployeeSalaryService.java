package com.hrportal.service;

import com.hrportal.model.EmployeeSalary;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeSalaryService {

    List<EmployeeSalary> getAll();

    EmployeeSalary get(Long id) throws NotFoundException;

    EmployeeSalary save(EmployeeSalary employeeSalary);

    EmployeeSalary update(Long id, EmployeeSalary employeeSalary) throws NotFoundException;

    EmployeeSalary delete(Long id) throws NotFoundException;
}
