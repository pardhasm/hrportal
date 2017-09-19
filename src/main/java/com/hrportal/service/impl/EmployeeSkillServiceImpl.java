package com.hrportal.service.impl;

import com.hrportal.model.EmployeeSkill;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeSkillRepository;
import com.hrportal.service.IEmployeeSkillService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class EmployeeSkillServiceImpl implements IEmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;


    @Override
    public List<EmployeeSkill> getAll() {
        return employeeSkillRepository.findAll();
    }

    @Override
    public EmployeeSkill get(Long id) throws NotFoundException {
        EmployeeSkill employeeSkill = employeeSkillRepository.findOne(id);
        if (Objects.isNull(employeeSkill)) {
            throw new NotFoundException("Employee Skill Not found with given id : " + id);
        }
        return employeeSkill;
    }

    @Override
    public EmployeeSkill save(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public EmployeeSkill update(Long id, EmployeeSkill employeeSkill) throws NotFoundException {
        if (!employeeSkillRepository.exists(employeeSkill.getId())) {
            throw new NotFoundException("Employee Skill Not found with given id : " + employeeSkill.getId());
        }
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public EmployeeSkill delete(Long id) throws NotFoundException {
        EmployeeSkill employeeSkill = employeeSkillRepository.findOne(id);
        if (!Objects.isNull(employeeSkill)) {
            throw new NotFoundException("Employee Skill Not found with given id : " + id);
        }
        employeeSkill.setRecordStatus(RecordStatus.INACTIVE);
        return employeeSkillRepository.save(employeeSkill);
    }
}
