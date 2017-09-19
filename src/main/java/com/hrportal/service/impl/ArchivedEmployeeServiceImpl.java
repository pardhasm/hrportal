package com.hrportal.service.impl;

import com.hrportal.model.ArchivedEmployee;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.ArchivedEmployeeRepository;
import com.hrportal.service.IArchivedEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class ArchivedEmployeeServiceImpl implements IArchivedEmployeeService {

    @Autowired
    private ArchivedEmployeeRepository archivedEmployeeRepository;


    @Override
    public List<ArchivedEmployee> getAll() {
        return archivedEmployeeRepository.findAll();
    }

    @Override
    public ArchivedEmployee get(Long id) throws NotFoundException {
        ArchivedEmployee archivedEmployee = archivedEmployeeRepository.findOne(id);
        if (Objects.isNull(archivedEmployee)) {
            throw new NotFoundException("Archived Employee Not found with given id : " + id);
        }
        return archivedEmployee;
    }

    @Override
    public ArchivedEmployee save(ArchivedEmployee archivedEmployee) {
        return archivedEmployeeRepository.save(archivedEmployee);
    }

    @Override
    public ArchivedEmployee update(Long id, ArchivedEmployee archivedEmployee) throws NotFoundException {
        if (!archivedEmployeeRepository.exists(archivedEmployee.getId())) {
            throw new NotFoundException("Archived Employee Not found with given id : " + archivedEmployee.getId());
        }
        return archivedEmployeeRepository.save(archivedEmployee);
    }

    @Override
    public ArchivedEmployee delete(Long id) throws NotFoundException {
        ArchivedEmployee archivedEmployee = archivedEmployeeRepository.findOne(id);
        if (!Objects.isNull(archivedEmployee)) {
            throw new NotFoundException("Archived Employee Not found with given id : " + id);
        }
        archivedEmployee.setRecordStatus(RecordStatus.INACTIVE);
        return archivedEmployeeRepository.save(archivedEmployee);
    }
}
