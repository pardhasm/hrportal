package com.hrportal.service.impl;

import com.hrportal.model.EmployeeEthnicity;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeEthnicityRepository;
import com.hrportal.service.IEmployeeEthnicityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeEthnicityServiceImpl implements IEmployeeEthnicityService {

    @Autowired
    private EmployeeEthnicityRepository employeeEthnicityRepository;


    @Override
    public List<EmployeeEthnicity> getAll() {
        return employeeEthnicityRepository.findAll();
    }

    @Override
    public EmployeeEthnicity get(Long id) throws NotFoundException {
        EmployeeEthnicity employeeEthnicity = employeeEthnicityRepository.findOne(id);
        if (Objects.isNull(employeeEthnicity)) {
            throw new NotFoundException("EmployeeEthnicity Not found with given id : " + id);
        }
        return employeeEthnicity;
    }

    @Override
    public EmployeeEthnicity save(EmployeeEthnicity employeeEthnicity) {
        return employeeEthnicityRepository.save(employeeEthnicity);
    }

    @Override
    public EmployeeEthnicity update(Long id, EmployeeEthnicity employeeEthnicity) throws NotFoundException {
        if (!employeeEthnicityRepository.exists(employeeEthnicity.getId())) {
            throw new NotFoundException("EmployeeEthnicity Not found with given id : " + employeeEthnicity.getId());
        }
        return employeeEthnicityRepository.save(employeeEthnicity);
    }

    @Override
    public EmployeeEthnicity delete(Long id) throws NotFoundException {
        EmployeeEthnicity employeeEthnicity = employeeEthnicityRepository.findOne(id);
        if (!Objects.isNull(employeeEthnicity)) {
            throw new NotFoundException("EmployeeEthnicity Not found with given id : " + id);
        }
        employeeEthnicity.setRecordStatus(RecordStatus.INACTIVE);
        return employeeEthnicityRepository.save(employeeEthnicity);
    }
}
