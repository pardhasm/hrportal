package com.hrportal.service;

import com.hrportal.model.EmployeeLanguage;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeLanguageService {

    List<EmployeeLanguage> getAll();

    EmployeeLanguage get(Long id) throws NotFoundException;

    EmployeeLanguage save(EmployeeLanguage employeeLanguage);

    EmployeeLanguage update(Long id, EmployeeLanguage employeeLanguage) throws NotFoundException;

    EmployeeLanguage delete(Long id) throws NotFoundException;
}
