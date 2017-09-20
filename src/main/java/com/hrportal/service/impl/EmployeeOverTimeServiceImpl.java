package com.hrportal.service.impl;

import com.hrportal.model.EmployeeOvertime;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeOvertimeRepository;
import com.hrportal.service.IEmployeeOvertimeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeOverTimeServiceImpl implements IEmployeeOvertimeService {

    @Autowired
    private EmployeeOvertimeRepository employeeOverTimeRepository;


    @Override
    public List<EmployeeOvertime> getAll() {
        return employeeOverTimeRepository.findAll();
    }

    @Override
    public EmployeeOvertime get(Long id) throws NotFoundException {
        EmployeeOvertime employeeOverTime = employeeOverTimeRepository.findOne(id);
        if (Objects.isNull(employeeOverTime)) {
            throw new NotFoundException("EmployeeOverTime Not found with given id : " + id);
        }
        return employeeOverTime;
    }

    @Override
    public EmployeeOvertime save(EmployeeOvertime employeeOverTime) {
        return employeeOverTimeRepository.save(employeeOverTime);
    }

    @Override
    public EmployeeOvertime update(Long id, EmployeeOvertime employeeOverTime) throws NotFoundException {
        if (!employeeOverTimeRepository.exists(employeeOverTime.getId())) {
            throw new NotFoundException("EmployeeOverTime Not found with given id : " + employeeOverTime.getId());
        }
        return employeeOverTimeRepository.save(employeeOverTime);
    }

    @Override
    public EmployeeOvertime delete(Long id) throws NotFoundException {
        EmployeeOvertime employeeOverTime = employeeOverTimeRepository.findOne(id);
        if (!Objects.isNull(employeeOverTime)) {
            throw new NotFoundException("EmployeeOverTime Not found with given id : " + id);
        }
        employeeOverTime.setRecordStatus(RecordStatus.INACTIVE);
        return employeeOverTimeRepository.save(employeeOverTime);
    }
}
