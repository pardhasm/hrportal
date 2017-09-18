package com.hrportal.service;

import com.hrportal.model.CompanyStructure;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface ICompanyStructureService {

    List<CompanyStructure> getAll();

    CompanyStructure get(Long id) throws NotFoundException;

    CompanyStructure save(CompanyStructure companyStructure);

    CompanyStructure update(Long id, CompanyStructure companyStructure) throws NotFoundException;

    CompanyStructure delete(Long id) throws NotFoundException;
}
