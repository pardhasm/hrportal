package com.hrportal.service;

import com.hrportal.model.EmployeeTrainingSession;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeTrainingSessionService {

    List<EmployeeTrainingSession> getAll();

    EmployeeTrainingSession get(Long id) throws NotFoundException;

    EmployeeTrainingSession save(EmployeeTrainingSession employeeTrainingSession);

    EmployeeTrainingSession update(Long id, EmployeeTrainingSession employeeTrainingSession) throws NotFoundException;

    EmployeeTrainingSession delete(Long id) throws NotFoundException;
}
