package com.hrportal.service;

import com.hrportal.model.SalaryComponent;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface ISalaryComponentService {

    List<SalaryComponent> getAll();

    SalaryComponent get(Long id) throws NotFoundException;

    SalaryComponent save(SalaryComponent salaryComponent);

    SalaryComponent update(Long id, SalaryComponent salaryComponent) throws NotFoundException;

    SalaryComponent delete(Long id) throws NotFoundException;
}
