package com.hrportal.service.impl;

import com.hrportal.model.EmployeeExpense;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeExpenseRepository;
import com.hrportal.service.IEmployeeExpenseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeExpenseServiceImpl implements IEmployeeExpenseService {

    @Autowired
    private EmployeeExpenseRepository employeeExpenseRepository;


    @Override
    public List<EmployeeExpense> getAll() {
        return employeeExpenseRepository.findAll();
    }

    @Override
    public EmployeeExpense get(Long id) throws NotFoundException {
        EmployeeExpense employeeExpense = employeeExpenseRepository.findOne(id);
        if (Objects.isNull(employeeExpense)) {
            throw new NotFoundException("EmployeeExpense Not found with given id : " + id);
        }
        return employeeExpense;
    }

    @Override
    public EmployeeExpense save(EmployeeExpense employeeExpense) {
        return employeeExpenseRepository.save(employeeExpense);
    }

    @Override
    public EmployeeExpense update(Long id, EmployeeExpense employeeExpense) throws NotFoundException {
        if (!employeeExpenseRepository.exists(employeeExpense.getId())) {
            throw new NotFoundException("EmployeeExpense Not found with given id : " + employeeExpense.getId());
        }
        return employeeExpenseRepository.save(employeeExpense);
    }

    @Override
    public EmployeeExpense delete(Long id) throws NotFoundException {
        EmployeeExpense employeeExpense = employeeExpenseRepository.findOne(id);
        if (!Objects.isNull(employeeExpense)) {
            throw new NotFoundException("EmployeeExpense Not found with given id : " + id);
        }
        employeeExpense.setRecordStatus(RecordStatus.INACTIVE);
        return employeeExpenseRepository.save(employeeExpense);
    }
}
