package com.hrportal.service.impl;

import com.hrportal.model.EmployeeCertification;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeCertificationRepository;
import com.hrportal.service.IEmployeeCertificationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class EmployeeCertificationServiceImpl implements IEmployeeCertificationService {

    @Autowired
    private EmployeeCertificationRepository employeeCertificationRepository;


    @Override
    public List<EmployeeCertification> getAll() {
        return employeeCertificationRepository.findAll();
    }

    @Override
    public EmployeeCertification get(Long id) throws NotFoundException {
        EmployeeCertification employeeCertification = employeeCertificationRepository.findOne(id);
        if (Objects.isNull(employeeCertification)) {
            throw new NotFoundException("EmployeeCertification Not found with given id : " + id);
        }
        return employeeCertification;
    }

    @Override
    public EmployeeCertification save(EmployeeCertification employeeCertification) {
        return employeeCertificationRepository.save(employeeCertification);
    }

    @Override
    public EmployeeCertification update(Long id, EmployeeCertification employeeCertification) throws NotFoundException {
        if (!employeeCertificationRepository.exists(employeeCertification.getId())) {
            throw new NotFoundException("EmployeeCertification Not found with given id : " + employeeCertification.getId());
        }
        return employeeCertificationRepository.save(employeeCertification);
    }

    @Override
    public EmployeeCertification delete(Long id) throws NotFoundException {
        EmployeeCertification employeeCertification = employeeCertificationRepository.findOne(id);
        if (!Objects.isNull(employeeCertification)) {
            throw new NotFoundException("EmployeeCertification Not found with given id : " + id);
        }
        employeeCertification.setRecordStatus(RecordStatus.INACTIVE);
        return employeeCertificationRepository.save(employeeCertification);
    }


}
