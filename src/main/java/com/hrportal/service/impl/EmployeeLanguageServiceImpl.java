package com.hrportal.service.impl;

import com.hrportal.model.EmployeeLanguage;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeLanguageRepository;
import com.hrportal.service.IEmployeeLanguageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeLanguageServiceImpl implements IEmployeeLanguageService {

    @Autowired
    private EmployeeLanguageRepository employeeLanguageRepository;


    @Override
    public List<EmployeeLanguage> getAll() {
        return employeeLanguageRepository.findAll();
    }

    @Override
    public EmployeeLanguage get(Long id) throws NotFoundException {
        EmployeeLanguage employeeLanguage = employeeLanguageRepository.findOne(id);
        if (Objects.isNull(employeeLanguage)) {
            throw new NotFoundException("EmployeeLanguage Not found with given id : " + id);
        }
        return employeeLanguage;
    }

    @Override
    public EmployeeLanguage save(EmployeeLanguage employeeLanguage) {
        return employeeLanguageRepository.save(employeeLanguage);
    }

    @Override
    public EmployeeLanguage update(Long id, EmployeeLanguage employeeLanguage) throws NotFoundException {
        if (!employeeLanguageRepository.exists(employeeLanguage.getId())) {
            throw new NotFoundException("EmployeeLanguage Not found with given id : " + employeeLanguage.getId());
        }
        return employeeLanguageRepository.save(employeeLanguage);
    }

    @Override
    public EmployeeLanguage delete(Long id) throws NotFoundException {
        EmployeeLanguage employeeLanguage = employeeLanguageRepository.findOne(id);
        if (!Objects.isNull(employeeLanguage)) {
            throw new NotFoundException("EmployeeLanguage Not found with given id : " + id);
        }
        employeeLanguage.setRecordStatus(RecordStatus.INACTIVE);
        return employeeLanguageRepository.save(employeeLanguage);
    }
}
