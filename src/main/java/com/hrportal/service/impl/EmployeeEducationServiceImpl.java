package com.hrportal.service.impl;

import com.hrportal.model.EmployeeEducation;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeEducationRepository;
import com.hrportal.service.IEmployeeEducationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public class EmployeeEducationServiceImpl implements IEmployeeEducationService {

    @Autowired
    private EmployeeEducationRepository employeeEducationRepository;


    @Override
    public List<EmployeeEducation> getAll() {
        return employeeEducationRepository.findAll();
    }

    @Override
    public EmployeeEducation get(Long id) throws NotFoundException {
        EmployeeEducation employeeEducation = employeeEducationRepository.findOne(id);
        if (Objects.isNull(employeeEducation)) {
            throw new NotFoundException("Employee Education Not found with given id : " + id);
        }
        return employeeEducation;
    }

    @Override
    public EmployeeEducation save(EmployeeEducation employeeEducation) {
        return employeeEducationRepository.save(employeeEducation);
    }

    @Override
    public EmployeeEducation update(Long id, EmployeeEducation employeeEducation) throws NotFoundException {
        if (!employeeEducationRepository.exists(employeeEducation.getId())) {
            throw new NotFoundException("Candidate Not found with given id : " + employeeEducation.getId());
        }
        return employeeEducationRepository.save(employeeEducation);
    }

    @Override
    public EmployeeEducation delete(Long id) throws NotFoundException {
        EmployeeEducation employeeEducation = employeeEducationRepository.findOne(id);
        if (!Objects.isNull(employeeEducation)) {
            throw new NotFoundException("Employee Education Not found with given id : " + id);
        }
        employeeEducation.setRecordStatus(RecordStatus.INACTIVE);
        return employeeEducationRepository.save(employeeEducation);
    }


}
