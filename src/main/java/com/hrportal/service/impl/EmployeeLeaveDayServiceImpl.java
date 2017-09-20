package com.hrportal.service.impl;

import com.hrportal.model.EmployeeLeaveDay;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeLeaveDayRepository;
import com.hrportal.service.IEmployeeLeaveDayService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeLeaveDayServiceImpl implements IEmployeeLeaveDayService {

    @Autowired
    private EmployeeLeaveDayRepository employeeLeaveDayRepository;


    @Override
    public List<EmployeeLeaveDay> getAll() {
        return employeeLeaveDayRepository.findAll();
    }

    @Override
    public EmployeeLeaveDay get(Long id) throws NotFoundException {
        EmployeeLeaveDay employeeLeaveDay = employeeLeaveDayRepository.findOne(id);
        if (Objects.isNull(employeeLeaveDay)) {
            throw new NotFoundException("EmployeeLeaveDay Not found with given id : " + id);
        }
        return employeeLeaveDay;
    }

    @Override
    public EmployeeLeaveDay save(EmployeeLeaveDay employeeLeaveDay) {
        return employeeLeaveDayRepository.save(employeeLeaveDay);
    }

    @Override
    public EmployeeLeaveDay update(Long id, EmployeeLeaveDay employeeLeaveDay) throws NotFoundException {
        if (!employeeLeaveDayRepository.exists(employeeLeaveDay.getId())) {
            throw new NotFoundException("EmployeeLeaveDay Not found with given id : " + employeeLeaveDay.getId());
        }
        return employeeLeaveDayRepository.save(employeeLeaveDay);
    }

    @Override
    public EmployeeLeaveDay delete(Long id) throws NotFoundException {
        EmployeeLeaveDay employeeLeaveDay = employeeLeaveDayRepository.findOne(id);
        if (!Objects.isNull(employeeLeaveDay)) {
            throw new NotFoundException("EmployeeLeaveDay Not found with given id : " + id);
        }
        employeeLeaveDay.setRecordStatus(RecordStatus.INACTIVE);
        return employeeLeaveDayRepository.save(employeeLeaveDay);
    }
}
