package com.hrportal.service.impl;

import com.hrportal.model.EmployeeProject;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeProjectRepository;
import com.hrportal.service.IEmployeeProjectService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeProjectServiceImpl implements IEmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;


    @Override
    public List<EmployeeProject> getAll() {
        return employeeProjectRepository.findAll();
    }

    @Override
    public EmployeeProject get(Long id) throws NotFoundException {
        EmployeeProject employeeProject = employeeProjectRepository.findOne(id);
        if (Objects.isNull(employeeProject)) {
            throw new NotFoundException("EmployeeProject Not found with given id : " + id);
        }
        return employeeProject;
    }

    @Override
    public EmployeeProject save(EmployeeProject employeeProject) {
        return employeeProjectRepository.save(employeeProject);
    }

    @Override
    public EmployeeProject update(Long id, EmployeeProject employeeProject) throws NotFoundException {
        if (!employeeProjectRepository.exists(employeeProject.getId())) {
            throw new NotFoundException("EmployeeProject Not found with given id : " + employeeProject.getId());
        }
        return employeeProjectRepository.save(employeeProject);
    }

    @Override
    public EmployeeProject delete(Long id) throws NotFoundException {
        EmployeeProject employeeProject = employeeProjectRepository.findOne(id);
        if (!Objects.isNull(employeeProject)) {
            throw new NotFoundException("EmployeeProject Not found with given id : " + id);
        }
        employeeProject.setRecordStatus(RecordStatus.INACTIVE);
        return employeeProjectRepository.save(employeeProject);
    }
}
