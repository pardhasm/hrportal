package com.hrportal.service.impl;

import com.hrportal.model.EmployeeLeaveLog;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeLeaveLogRepository;
import com.hrportal.service.IEmployeeLeaveLogService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeLeaveLogServiceImpl implements IEmployeeLeaveLogService {

    @Autowired
    private EmployeeLeaveLogRepository employeeLeaveLogRepository;


    @Override
    public List<EmployeeLeaveLog> getAll() {
        return employeeLeaveLogRepository.findAll();
    }

    @Override
    public EmployeeLeaveLog get(Long id) throws NotFoundException {
        EmployeeLeaveLog employeeLeaveLog = employeeLeaveLogRepository.findOne(id);
        if (Objects.isNull(employeeLeaveLog)) {
            throw new NotFoundException("EmployeeLeaveLog Not found with given id : " + id);
        }
        return employeeLeaveLog;
    }

    @Override
    public EmployeeLeaveLog save(EmployeeLeaveLog employeeLeaveLog) {
        return employeeLeaveLogRepository.save(employeeLeaveLog);
    }

    @Override
    public EmployeeLeaveLog update(Long id, EmployeeLeaveLog employeeLeaveLog) throws NotFoundException {
        if (!employeeLeaveLogRepository.exists(employeeLeaveLog.getId())) {
            throw new NotFoundException("EmployeeLeaveLog Not found with given id : " + employeeLeaveLog.getId());
        }
        return employeeLeaveLogRepository.save(employeeLeaveLog);
    }

    @Override
    public EmployeeLeaveLog delete(Long id) throws NotFoundException {
        EmployeeLeaveLog employeeLeaveLog = employeeLeaveLogRepository.findOne(id);
        if (!Objects.isNull(employeeLeaveLog)) {
            throw new NotFoundException("EmployeeLeaveLog Not found with given id : " + id);
        }
        employeeLeaveLog.setRecordStatus(RecordStatus.INACTIVE);
        return employeeLeaveLogRepository.save(employeeLeaveLog);
    }
}
