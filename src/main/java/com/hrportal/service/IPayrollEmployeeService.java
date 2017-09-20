package com.hrportal.service;

import com.hrportal.model.PayrollEmployee;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IPayrollEmployeeService {

    List<PayrollEmployee> getAll();

    PayrollEmployee get(Long id) throws NotFoundException;

    PayrollEmployee save(PayrollEmployee payrollEmployee);

    PayrollEmployee update(Long id, PayrollEmployee payrollEmployee) throws NotFoundException;

    PayrollEmployee delete(Long id) throws NotFoundException;
}
