package com.hrportal.service;

import com.hrportal.model.EmployeeApproval;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IEmployeeApprovalService {

    List<EmployeeApproval> getAll();

    EmployeeApproval get(Long id) throws NotFoundException;

    EmployeeApproval save(EmployeeApproval employeeApproval);

    EmployeeApproval update(Long id, EmployeeApproval employeeApproval) throws NotFoundException;

    EmployeeApproval delete(Long id) throws NotFoundException;
}
