package com.hrportal.service.impl;

import com.hrportal.model.EmployeeImmigrationStatus;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeImmigrationStatusRepository;
import com.hrportal.service.IEmployeeImmigrationStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeImmigrationStatusServiceImpl implements IEmployeeImmigrationStatusService {

    @Autowired
    private EmployeeImmigrationStatusRepository employeeImmigrationStatusRepository;


    @Override
    public List<EmployeeImmigrationStatus> getAll() {
        return employeeImmigrationStatusRepository.findAll();
    }

    @Override
    public EmployeeImmigrationStatus get(Long id) throws NotFoundException {
        EmployeeImmigrationStatus employeeImmigrationStatus = employeeImmigrationStatusRepository.findOne(id);
        if (Objects.isNull(employeeImmigrationStatus)) {
            throw new NotFoundException("EmployeeImmigrationStatus Not found with given id : " + id);
        }
        return employeeImmigrationStatus;
    }

    @Override
    public EmployeeImmigrationStatus save(EmployeeImmigrationStatus employeeImmigrationStatus) {
        return employeeImmigrationStatusRepository.save(employeeImmigrationStatus);
    }

    @Override
    public EmployeeImmigrationStatus update(Long id, EmployeeImmigrationStatus employeeImmigrationStatus) throws NotFoundException {
        if (!employeeImmigrationStatusRepository.exists(employeeImmigrationStatus.getId())) {
            throw new NotFoundException("EmployeeImmigrationStatus Not found with given id : " + employeeImmigrationStatus.getId());
        }
        return employeeImmigrationStatusRepository.save(employeeImmigrationStatus);
    }

    @Override
    public EmployeeImmigrationStatus delete(Long id) throws NotFoundException {
        EmployeeImmigrationStatus employeeImmigrationStatus = employeeImmigrationStatusRepository.findOne(id);
        if (!Objects.isNull(employeeImmigrationStatus)) {
            throw new NotFoundException("EmployeeImmigrationStatus Not found with given id : " + id);
        }
        employeeImmigrationStatus.setRecordStatus(RecordStatus.INACTIVE);
        return employeeImmigrationStatusRepository.save(employeeImmigrationStatus);
    }
}
