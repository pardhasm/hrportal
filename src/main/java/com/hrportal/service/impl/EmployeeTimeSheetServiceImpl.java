package com.hrportal.service.impl;

import com.hrportal.model.EmployeeTimeSheet;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeTimeSheetRepository;
import com.hrportal.service.IEmployeeTimeSheetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public class EmployeeTimeSheetServiceImpl implements IEmployeeTimeSheetService {

    @Autowired
    private EmployeeTimeSheetRepository employeeTimeSheetRepository;


    @Override
    public List<EmployeeTimeSheet> getAll() {
        return employeeTimeSheetRepository.findAll();
    }

    @Override
    public EmployeeTimeSheet get(Long id) throws NotFoundException {
        EmployeeTimeSheet employeeTimeSheet = employeeTimeSheetRepository.findOne(id);
        if (Objects.isNull(employeeTimeSheet)) {
            throw new NotFoundException("EmployeeTimeSheet Not found with given id : " + id);
        }
        return employeeTimeSheet;
    }

    @Override
    public EmployeeTimeSheet save(EmployeeTimeSheet employeeTimeSheet) {
        return employeeTimeSheetRepository.save(employeeTimeSheet);
    }

    @Override
    public EmployeeTimeSheet update(Long id, EmployeeTimeSheet employeeTimeSheet) throws NotFoundException {
        if (!employeeTimeSheetRepository.exists(employeeTimeSheet.getId())) {
            throw new NotFoundException("EmployeeTimeSheet Not found with given id : " + employeeTimeSheet.getId());
        }
        return employeeTimeSheetRepository.save(employeeTimeSheet);
    }

    @Override
    public EmployeeTimeSheet delete(Long id) throws NotFoundException {
        EmployeeTimeSheet employeeTimeSheet = employeeTimeSheetRepository.findOne(id);
        if (!Objects.isNull(employeeTimeSheet)) {
            throw new NotFoundException("EmployeeTimeSheet Not found with given id : " + id);
        }
        employeeTimeSheet.setRecordStatus(RecordStatus.INACTIVE);
        return employeeTimeSheetRepository.save(employeeTimeSheet);
    }
}
