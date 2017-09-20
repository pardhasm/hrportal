package com.hrportal.service.impl;

import com.hrportal.model.EmployeeImmigration;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeImmigrationRepository;
import com.hrportal.service.IEmployeeImmigrationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeImmigrationServiceImpl implements IEmployeeImmigrationService {

    @Autowired
    private EmployeeImmigrationRepository employeeImmigrationRepository;


    @Override
    public List<EmployeeImmigration> getAll() {
        return employeeImmigrationRepository.findAll();
    }

    @Override
    public EmployeeImmigration get(Long id) throws NotFoundException {
        EmployeeImmigration employeeImmigration = employeeImmigrationRepository.findOne(id);
        if (Objects.isNull(employeeImmigration)) {
            throw new NotFoundException("EmployeeImmigration Not found with given id : " + id);
        }
        return employeeImmigration;
    }

    @Override
    public EmployeeImmigration save(EmployeeImmigration employeeImmigration) {
        return employeeImmigrationRepository.save(employeeImmigration);
    }

    @Override
    public EmployeeImmigration update(Long id, EmployeeImmigration employeeImmigration) throws NotFoundException {
        if (!employeeImmigrationRepository.exists(employeeImmigration.getId())) {
            throw new NotFoundException("EmployeeImmigration Not found with given id : " + employeeImmigration.getId());
        }
        return employeeImmigrationRepository.save(employeeImmigration);
    }

    @Override
    public EmployeeImmigration delete(Long id) throws NotFoundException {
        EmployeeImmigration employeeImmigration = employeeImmigrationRepository.findOne(id);
        if (!Objects.isNull(employeeImmigration)) {
            throw new NotFoundException("EmployeeImmigration Not found with given id : " + id);
        }
        employeeImmigration.setRecordStatus(RecordStatus.INACTIVE);
        return employeeImmigrationRepository.save(employeeImmigration);
    }
}
