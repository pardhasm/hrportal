package com.hrportal.service;

import com.hrportal.model.EmployeeCompanyLoan;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeCompanyLoanService {

    List<EmployeeCompanyLoan> getAll();

    EmployeeCompanyLoan get(Long id) throws NotFoundException;

    EmployeeCompanyLoan save(EmployeeCompanyLoan employeeCompanyLoan);

    EmployeeCompanyLoan update(Long id, EmployeeCompanyLoan employeeCompanyLoan) throws NotFoundException;

    EmployeeCompanyLoan delete(Long id) throws NotFoundException;
}
