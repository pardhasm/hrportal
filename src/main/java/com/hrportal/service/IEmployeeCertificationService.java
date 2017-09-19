package com.hrportal.service;

import com.hrportal.model.EmployeeCertification;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IEmployeeCertificationService {

    List<EmployeeCertification> getAll();

    EmployeeCertification get(Long id) throws NotFoundException;

    EmployeeCertification save(EmployeeCertification employeeCertification);

    EmployeeCertification update(Long id, EmployeeCertification EmployeeCertification) throws NotFoundException;

    EmployeeCertification delete(Long id) throws NotFoundException;
}
