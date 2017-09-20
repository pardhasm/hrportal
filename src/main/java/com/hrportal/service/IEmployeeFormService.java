package com.hrportal.service;

import com.hrportal.model.EmployeeForm;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeFormService {

    List<EmployeeForm> getAll();

    EmployeeForm get(Long id) throws NotFoundException;

    EmployeeForm save(EmployeeForm employeeForm);

    EmployeeForm update(Long id, EmployeeForm employeeForm) throws NotFoundException;

    EmployeeForm delete(Long id) throws NotFoundException;
}
