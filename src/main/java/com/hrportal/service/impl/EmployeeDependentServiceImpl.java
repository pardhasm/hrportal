package com.hrportal.service.impl;

import com.hrportal.model.EmployeeDependent;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeDependentRepository;
import com.hrportal.service.IEmployeeDependentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeDependentServiceImpl implements IEmployeeDependentService {

    @Autowired
    private EmployeeDependentRepository employeeDependentRepository;


    @Override
    public List<EmployeeDependent> getAll() {
        return employeeDependentRepository.findAll();
    }

    @Override
    public EmployeeDependent get(Long id) throws NotFoundException {
        EmployeeDependent employeeDependent = employeeDependentRepository.findOne(id);
        if (Objects.isNull(employeeDependent)) {
            throw new NotFoundException("EmployeeDependent Not found with given id : " + id);
        }
        return employeeDependent;
    }

    @Override
    public EmployeeDependent save(EmployeeDependent call) {
        return employeeDependentRepository.save(call);
    }

    @Override
    public EmployeeDependent update(Long id, EmployeeDependent employeeDependent) throws NotFoundException {
        if (!employeeDependentRepository.exists(employeeDependent.getId())) {
            throw new NotFoundException("EmployeeDependent Not found with given id : " + employeeDependent.getId());
        }
        return employeeDependentRepository.save(employeeDependent);
    }

    @Override
    public EmployeeDependent delete(Long id) throws NotFoundException {
        EmployeeDependent employeeDependent = employeeDependentRepository.findOne(id);
        if (!Objects.isNull(employeeDependent)) {
            throw new NotFoundException("EmployeeDependent Not found with given id : " + id);
        }
        employeeDependent.setRecordStatus(RecordStatus.INACTIVE);
        return employeeDependentRepository.save(employeeDependent);
    }
}
