package com.hrportal.service.impl;

import com.hrportal.model.EmployeeDataHistory;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeDataHistoryRepository;
import com.hrportal.service.IEmployeeDataHistoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeDataHistoryServiceImpl implements IEmployeeDataHistoryService {

    @Autowired
    private EmployeeDataHistoryRepository employeeDataHistoryRepository;


    @Override
    public List<EmployeeDataHistory> getAll() {
        return employeeDataHistoryRepository.findAll();
    }

    @Override
    public EmployeeDataHistory get(Long id) throws NotFoundException {
        EmployeeDataHistory employeeDataHistory = employeeDataHistoryRepository.findOne(id);
        if (Objects.isNull(employeeDataHistory)) {
            throw new NotFoundException("EmployeeDataHistory Not found with given id : " + id);
        }
        return employeeDataHistory;
    }

    @Override
    public EmployeeDataHistory save(EmployeeDataHistory employeeDataHistory) {
        return employeeDataHistoryRepository.save(employeeDataHistory);
    }

    @Override
    public EmployeeDataHistory update(Long id, EmployeeDataHistory employeeDataHistory) throws NotFoundException {
        if (!employeeDataHistoryRepository.exists(employeeDataHistory.getId())) {
            throw new NotFoundException("EmployeeDataHistory Not found with given id : " + employeeDataHistory.getId());
        }
        return employeeDataHistoryRepository.save(employeeDataHistory);
    }

    @Override
    public EmployeeDataHistory delete(Long id) throws NotFoundException {
        EmployeeDataHistory employeeDataHistory = employeeDataHistoryRepository.findOne(id);
        if (!Objects.isNull(employeeDataHistory)) {
            throw new NotFoundException("EmployeeDataHistory Not found with given id : " + id);
        }
        employeeDataHistory.setRecordStatus(RecordStatus.INACTIVE);
        return employeeDataHistoryRepository.save(employeeDataHistory);
    }
}
