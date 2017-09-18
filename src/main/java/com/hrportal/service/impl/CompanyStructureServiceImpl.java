package com.hrportal.service.impl;

import com.hrportal.model.CompanyStructure;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CompanyStructureRepository;
import com.hrportal.service.ICompanyStructureService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class CompanyStructureServiceImpl implements ICompanyStructureService{

    @Autowired
    private CompanyStructureRepository companyStructureRepository;


    @Override
    public List<CompanyStructure> getAll() {
        return companyStructureRepository.findAll();
    }

    @Override
    public CompanyStructure get(Long id) throws NotFoundException {
        CompanyStructure companyStructure = companyStructureRepository.findOne(id);
        if (Objects.isNull(companyStructure)) {
            throw new NotFoundException("Company Structure Not found with given id : " + id);
        }
        return companyStructure;
    }

    @Override
    public CompanyStructure save(CompanyStructure companyStructure) {
        return companyStructureRepository.save(companyStructure);
    }

    @Override
    public CompanyStructure update(Long id, CompanyStructure companyStructure) throws NotFoundException {
        if (!companyStructureRepository.exists(companyStructure.getId())) {
            throw new NotFoundException("Company Structure Not found with given id : " + companyStructure.getId());
        }
        return companyStructureRepository.save(companyStructure);
    }

    @Override
    public CompanyStructure delete(Long id) throws NotFoundException {
        CompanyStructure companyStructure = companyStructureRepository.findOne(id);
        if (!Objects.isNull(companyStructure)) {
            throw new NotFoundException("Company Structure Not found with given id : " + id);
        }
        companyStructure.setRecordStatus(RecordStatus.INACTIVE);
        return companyStructureRepository.save(companyStructure);
    }
}
