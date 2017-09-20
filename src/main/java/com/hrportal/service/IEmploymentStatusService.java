package com.hrportal.service;

import com.hrportal.model.EmploymentStatus;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmploymentStatusService {

    List<EmploymentStatus> getAll();

    EmploymentStatus get(Long id) throws NotFoundException;

    EmploymentStatus save(EmploymentStatus employmentStatus);

    EmploymentStatus update(Long id, EmploymentStatus employmentStatus) throws NotFoundException;

    EmploymentStatus delete(Long id) throws NotFoundException;
}
