package com.hrportal.service.impl;

import com.hrportal.model.EmployeeTravelRecord;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeTravelRecordRepository;
import com.hrportal.service.IEmployeeTravelRecordService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeTravelRecordServiceImpl implements IEmployeeTravelRecordService {

    @Autowired
    private EmployeeTravelRecordRepository employeeTravelRecordRepository;


    @Override
    public List<EmployeeTravelRecord> getAll() {
        return employeeTravelRecordRepository.findAll();
    }

    @Override
    public EmployeeTravelRecord get(Long id) throws NotFoundException {
        EmployeeTravelRecord employeeTravelRecord = employeeTravelRecordRepository.findOne(id);
        if (Objects.isNull(employeeTravelRecord)) {
            throw new NotFoundException("EmployeeTravelRecord Not found with given id : " + id);
        }
        return employeeTravelRecord;
    }

    @Override
    public EmployeeTravelRecord save(EmployeeTravelRecord employeeTravelRecord) {
        return employeeTravelRecordRepository.save(employeeTravelRecord);
    }

    @Override
    public EmployeeTravelRecord update(Long id, EmployeeTravelRecord employeeTravelRecord) throws NotFoundException {
        if (!employeeTravelRecordRepository.exists(employeeTravelRecord.getId())) {
            throw new NotFoundException("EmployeeTravelRecord Not found with given id : " + employeeTravelRecord.getId());
        }
        return employeeTravelRecordRepository.save(employeeTravelRecord);
    }

    @Override
    public EmployeeTravelRecord delete(Long id) throws NotFoundException {
        EmployeeTravelRecord employeeTravelRecord = employeeTravelRecordRepository.findOne(id);
        if (!Objects.isNull(employeeTravelRecord)) {
            throw new NotFoundException("EmployeeTravelRecord Not found with given id : " + id);
        }
        employeeTravelRecord.setRecordStatus(RecordStatus.INACTIVE);
        return employeeTravelRecordRepository.save(employeeTravelRecord);
    }
}
