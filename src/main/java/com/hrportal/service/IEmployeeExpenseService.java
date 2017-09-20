package com.hrportal.service;

import com.hrportal.model.EmployeeExpense;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeExpenseService {

    List<EmployeeExpense> getAll();

    EmployeeExpense get(Long id) throws NotFoundException;

    EmployeeExpense save(EmployeeExpense employeeExpense);

    EmployeeExpense update(Long id, EmployeeExpense employeeExpense) throws NotFoundException;

    EmployeeExpense delete(Long id) throws NotFoundException;
}
