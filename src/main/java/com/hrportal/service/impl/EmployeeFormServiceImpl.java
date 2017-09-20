package com.hrportal.service.impl;

import com.hrportal.model.EmployeeForm;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeFormRepository;
import com.hrportal.service.IEmployeeFormService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeFormServiceImpl implements IEmployeeFormService {

    @Autowired
    private EmployeeFormRepository employeeFormRepository;


    @Override
    public List<EmployeeForm> getAll() {
        return employeeFormRepository.findAll();
    }

    @Override
    public EmployeeForm get(Long id) throws NotFoundException {
        EmployeeForm employeeForm = employeeFormRepository.findOne(id);
        if (Objects.isNull(employeeForm)) {
            throw new NotFoundException("EmployeeForm Not found with given id : " + id);
        }
        return employeeForm;
    }

    @Override
    public EmployeeForm save(EmployeeForm employeeForm) {
        return employeeFormRepository.save(employeeForm);
    }

    @Override
    public EmployeeForm update(Long id, EmployeeForm employeeForm) throws NotFoundException {
        if (!employeeFormRepository.exists(employeeForm.getId())) {
            throw new NotFoundException("EmployeeForm Not found with given id : " + employeeForm.getId());
        }
        return employeeFormRepository.save(employeeForm);
    }

    @Override
    public EmployeeForm delete(Long id) throws NotFoundException {
        EmployeeForm employeeForm = employeeFormRepository.findOne(id);
        if (!Objects.isNull(employeeForm)) {
            throw new NotFoundException("EmployeeForm Not found with given id : " + id);
        }
        employeeForm.setRecordStatus(RecordStatus.INACTIVE);
        return employeeFormRepository.save(employeeForm);
    }
}
