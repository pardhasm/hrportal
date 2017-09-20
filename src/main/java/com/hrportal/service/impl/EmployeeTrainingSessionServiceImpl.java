package com.hrportal.service.impl;

import com.hrportal.model.EmployeeTrainingSession;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeTrainingSessionRepository;
import com.hrportal.service.IEmployeeTrainingSessionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeTrainingSessionServiceImpl implements IEmployeeTrainingSessionService {

    @Autowired
    private EmployeeTrainingSessionRepository employeeTrainingSessionRepository;


    @Override
    public List<EmployeeTrainingSession> getAll() {
        return employeeTrainingSessionRepository.findAll();
    }

    @Override
    public EmployeeTrainingSession get(Long id) throws NotFoundException {
        EmployeeTrainingSession employeeTrainingSession = employeeTrainingSessionRepository.findOne(id);
        if (Objects.isNull(employeeTrainingSession)) {
            throw new NotFoundException("EmployeeTrainingSession Not found with given id : " + id);
        }
        return employeeTrainingSession;
    }

    @Override
    public EmployeeTrainingSession save(EmployeeTrainingSession employeeTrainingSession) {
        return employeeTrainingSessionRepository.save(employeeTrainingSession);
    }

    @Override
    public EmployeeTrainingSession update(Long id, EmployeeTrainingSession employeeTrainingSession) throws NotFoundException {
        if (!employeeTrainingSessionRepository.exists(employeeTrainingSession.getId())) {
            throw new NotFoundException("EmployeeTrainingSession Not found with given id : " + employeeTrainingSession.getId());
        }
        return employeeTrainingSessionRepository.save(employeeTrainingSession);
    }

    @Override
    public EmployeeTrainingSession delete(Long id) throws NotFoundException {
        EmployeeTrainingSession employeeTrainingSession = employeeTrainingSessionRepository.findOne(id);
        if (!Objects.isNull(employeeTrainingSession)) {
            throw new NotFoundException("EmployeeTrainingSession Not found with given id : " + id);
        }
        employeeTrainingSession.setRecordStatus(RecordStatus.INACTIVE);
        return employeeTrainingSessionRepository.save(employeeTrainingSession);
    }
}
