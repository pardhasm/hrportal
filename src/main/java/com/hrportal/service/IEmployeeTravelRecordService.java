package com.hrportal.service;

import com.hrportal.model.EmployeeTravelRecord;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeTravelRecordService {

    List<EmployeeTravelRecord> getAll();

    EmployeeTravelRecord get(Long id) throws NotFoundException;

    EmployeeTravelRecord save(EmployeeTravelRecord employeeTravelRecord);

    EmployeeTravelRecord update(Long id, EmployeeTravelRecord employeeTravelRecord) throws NotFoundException;

    EmployeeTravelRecord delete(Long id) throws NotFoundException;
}
