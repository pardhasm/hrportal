package com.hrportal.service.impl;

import com.hrportal.model.EmployeeLeave;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeLeaveRepository;
import com.hrportal.service.IEmployeeLeaveService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public class EmployeeLeaveServiceImpl implements IEmployeeLeaveService {

    @Autowired
    private EmployeeLeaveRepository employeeLeaveRepository;


    @Override
    public List<EmployeeLeave> getAll() {
        return employeeLeaveRepository.findAll();
    }

    @Override
    public EmployeeLeave get(Long id) throws NotFoundException {
        EmployeeLeave employeeLeave = employeeLeaveRepository.findOne(id);
        if (Objects.isNull(employeeLeave)) {
            throw new NotFoundException("EmployeeLeave Not found with given id : " + id);
        }
        return employeeLeave;
    }

    @Override
    public EmployeeLeave save(EmployeeLeave employeeLeave) {
        return employeeLeaveRepository.save(employeeLeave);
    }

    @Override
    public EmployeeLeave update(Long id, EmployeeLeave employeeLeave) throws NotFoundException {
        if (!employeeLeaveRepository.exists(employeeLeave.getId())) {
            throw new NotFoundException("EmployeeLeave Not found with given id : " + employeeLeave.getId());
        }
        return employeeLeaveRepository.save(employeeLeave);
    }

    @Override
    public EmployeeLeave delete(Long id) throws NotFoundException {
        EmployeeLeave employeeLeave = employeeLeaveRepository.findOne(id);
        if (!Objects.isNull(employeeLeave)) {
            throw new NotFoundException("EmployeeLeave Not found with given id : " + id);
        }
        employeeLeave.setRecordStatus(RecordStatus.INACTIVE);
        return employeeLeaveRepository.save(employeeLeave);
    }
}
