package com.hrportal.service;

import com.hrportal.model.EmployeeProject;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeProjectService {

    List<EmployeeProject> getAll();

    EmployeeProject get(Long id) throws NotFoundException;

    EmployeeProject save(EmployeeProject employeeProject);

    EmployeeProject update(Long id, EmployeeProject employeeProject) throws NotFoundException;

    EmployeeProject delete(Long id) throws NotFoundException;
}
