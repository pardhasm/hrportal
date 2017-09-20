package com.hrportal.service.impl;

import com.hrportal.model.EmployeeAttendanceSheet;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeAttendanceSheetRepository;
import com.hrportal.service.IEmployeeAttendanceSheetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeAttendanceSheetServiceImpl implements IEmployeeAttendanceSheetService {

    @Autowired
    private EmployeeAttendanceSheetRepository employeeAttendanceSheetRepository;


    @Override
    public List<EmployeeAttendanceSheet> getAll() {
        return employeeAttendanceSheetRepository.findAll();
    }

    @Override
    public EmployeeAttendanceSheet get(Long id) throws NotFoundException {
        EmployeeAttendanceSheet employeeAttendanceSheet = employeeAttendanceSheetRepository.findOne(id);
        if (Objects.isNull(employeeAttendanceSheet)) {
            throw new NotFoundException("EmployeeAttendanceSheet Not found with given id : " + id);
        }
        return employeeAttendanceSheet;
    }

    @Override
    public EmployeeAttendanceSheet save(EmployeeAttendanceSheet employeeAttendanceSheet) {
        return employeeAttendanceSheetRepository.save(employeeAttendanceSheet);
    }

    @Override
    public EmployeeAttendanceSheet update(Long id, EmployeeAttendanceSheet employeeAttendanceSheet) throws NotFoundException {
        if (!employeeAttendanceSheetRepository.exists(employeeAttendanceSheet.getId())) {
            throw new NotFoundException("EmployeeAttendanceSheet Not found with given id : " + employeeAttendanceSheet.getId());
        }
        return employeeAttendanceSheetRepository.save(employeeAttendanceSheet);
    }

    @Override
    public EmployeeAttendanceSheet delete(Long id) throws NotFoundException {
        EmployeeAttendanceSheet employeeAttendanceSheet = employeeAttendanceSheetRepository.findOne(id);
        if (!Objects.isNull(employeeAttendanceSheet)) {
            throw new NotFoundException("EmployeeAttendanceSheet Not found with given id : " + id);
        }
        employeeAttendanceSheet.setRecordStatus(RecordStatus.INACTIVE);
        return employeeAttendanceSheetRepository.save(employeeAttendanceSheet);
    }


}
