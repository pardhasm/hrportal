package com.hrportal.service;

import com.hrportal.model.Employee;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IEmployeeService {

    List<Employee> getAll();

    Employee get(Long id) throws NotFoundException;

    Employee save(Employee employee);

    Employee update(Long id, Employee employee) throws NotFoundException;

    Employee delete(Long id) throws NotFoundException;
}
