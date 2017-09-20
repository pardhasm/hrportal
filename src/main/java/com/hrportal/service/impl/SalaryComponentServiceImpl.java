package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.SalaryComponent;
import com.hrportal.repository.SalaryComponentRepository;
import com.hrportal.service.ISalaryComponentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class SalaryComponentServiceImpl implements ISalaryComponentService {

    @Autowired
    private SalaryComponentRepository salaryComponentRepository;


    @Override
    public List<SalaryComponent> getAll() {
        return salaryComponentRepository.findAll();
    }

    @Override
    public SalaryComponent get(Long id) throws NotFoundException {
        SalaryComponent salaryComponent = salaryComponentRepository.findOne(id);
        if (Objects.isNull(salaryComponent)) {
            throw new NotFoundException("SalaryComponent Not found with given id : " + id);
        }
        return salaryComponent;
    }

    @Override
    public SalaryComponent save(SalaryComponent salaryComponent) {
        return salaryComponentRepository.save(salaryComponent);
    }

    @Override
    public SalaryComponent update(Long id, SalaryComponent salaryComponent) throws NotFoundException {
        if (!salaryComponentRepository.exists(salaryComponent.getId())) {
            throw new NotFoundException("SalaryComponent Not found with given id : " + salaryComponent.getId());
        }
        return salaryComponentRepository.save(salaryComponent);
    }

    @Override
    public SalaryComponent delete(Long id) throws NotFoundException {
        SalaryComponent salaryComponent = salaryComponentRepository.findOne(id);
        if (!Objects.isNull(salaryComponent)) {
            throw new NotFoundException("SalaryComponent Not found with given id : " + id);
        }
        salaryComponent.setRecordStatus(RecordStatus.INACTIVE);
        return salaryComponentRepository.save(salaryComponent);
    }
}
