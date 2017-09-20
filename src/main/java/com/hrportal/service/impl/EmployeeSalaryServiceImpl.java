package com.hrportal.service.impl;

import com.hrportal.model.EmployeeSalary;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeSalaryRepository;
import com.hrportal.service.IEmployeeSalaryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeSalaryServiceImpl implements IEmployeeSalaryService {

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;


    @Override
    public List<EmployeeSalary> getAll() {
        return employeeSalaryRepository.findAll();
    }

    @Override
    public EmployeeSalary get(Long id) throws NotFoundException {
        EmployeeSalary employeeSalary = employeeSalaryRepository.findOne(id);
        if (Objects.isNull(employeeSalary)) {
            throw new NotFoundException("EmployeeSalary Not found with given id : " + id);
        }
        return employeeSalary;
    }

    @Override
    public EmployeeSalary save(EmployeeSalary employeeSalary) {
        return employeeSalaryRepository.save(employeeSalary);
    }

    @Override
    public EmployeeSalary update(Long id, EmployeeSalary employeeSalary) throws NotFoundException {
        if (!employeeSalaryRepository.exists(employeeSalary.getId())) {
            throw new NotFoundException("EmployeeSalary Not found with given id : " + employeeSalary.getId());
        }
        return employeeSalaryRepository.save(employeeSalary);
    }

    @Override
    public EmployeeSalary delete(Long id) throws NotFoundException {
        EmployeeSalary employeeSalary = employeeSalaryRepository.findOne(id);
        if (!Objects.isNull(employeeSalary)) {
            throw new NotFoundException("EmployeeSalary Not found with given id : " + id);
        }
        employeeSalary.setRecordStatus(RecordStatus.INACTIVE);
        return employeeSalaryRepository.save(employeeSalary);
    }
}
