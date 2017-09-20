package com.hrportal.service.impl;

import com.hrportal.model.EmployeeTimeEntry;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeTimeEntryRepository;
import com.hrportal.service.IEmployeeTimeEntryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeTimeEntryServiceImpl implements IEmployeeTimeEntryService {

    @Autowired
    private EmployeeTimeEntryRepository employeeTimeEntryRepository;


    @Override
    public List<EmployeeTimeEntry> getAll() {
        return employeeTimeEntryRepository.findAll();
    }

    @Override
    public EmployeeTimeEntry get(Long id) throws NotFoundException {
        EmployeeTimeEntry employeeTimeEntry = employeeTimeEntryRepository.findOne(id);
        if (Objects.isNull(employeeTimeEntry)) {
            throw new NotFoundException("EmployeeTimeEntry Not found with given id : " + id);
        }
        return employeeTimeEntry;
    }

    @Override
    public EmployeeTimeEntry save(EmployeeTimeEntry employeeTimeEntry) {
        return employeeTimeEntryRepository.save(employeeTimeEntry);
    }

    @Override
    public EmployeeTimeEntry update(Long id, EmployeeTimeEntry employeeTimeEntry) throws NotFoundException {
        if (!employeeTimeEntryRepository.exists(employeeTimeEntry.getId())) {
            throw new NotFoundException("EmployeeTimeEntry Not found with given id : " + employeeTimeEntry.getId());
        }
        return employeeTimeEntryRepository.save(employeeTimeEntry);
    }

    @Override
    public EmployeeTimeEntry delete(Long id) throws NotFoundException {
        EmployeeTimeEntry employeeTimeEntry = employeeTimeEntryRepository.findOne(id);
        if (!Objects.isNull(employeeTimeEntry)) {
            throw new NotFoundException("EmployeeTimeEntry Not found with given id : " + id);
        }
        employeeTimeEntry.setRecordStatus(RecordStatus.INACTIVE);
        return employeeTimeEntryRepository.save(employeeTimeEntry);
    }
}
