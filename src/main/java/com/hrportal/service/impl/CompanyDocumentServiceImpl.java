package com.hrportal.service.impl;

import com.hrportal.model.CompanyDocument;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CompanyDocumentRepository;
import com.hrportal.service.ICompanyDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class CompanyDocumentServiceImpl implements ICompanyDocumentService {

    @Autowired
    private CompanyDocumentRepository companyDocumentRepository;


    @Override
    public List<CompanyDocument> getAll() {
        return companyDocumentRepository.findAll();
    }

    @Override
    public CompanyDocument get(Long id) throws NotFoundException {
        CompanyDocument companyDocument = companyDocumentRepository.findOne(id);
        if (Objects.isNull(companyDocument)) {
            throw new NotFoundException("Company Document Not found with given id : " + id);
        }
        return companyDocument;
    }

    @Override
    public CompanyDocument save(CompanyDocument companyDocument) {
        return companyDocumentRepository.save(companyDocument);
    }

    @Override
    public CompanyDocument update(Long id, CompanyDocument companyDocument) throws NotFoundException {
        if (!companyDocumentRepository.exists(companyDocument.getId())) {
            throw new NotFoundException("Company Document Not found with given id : " + companyDocument.getId());
        }
        return companyDocumentRepository.save(companyDocument);
    }

    @Override
    public CompanyDocument delete(Long id) throws NotFoundException {
        CompanyDocument companyDocument = companyDocumentRepository.findOne(id);
        if (!Objects.isNull(companyDocument)) {
            throw new NotFoundException("Company Document Not found with given id : " + id);
        }
        companyDocument.setRecordStatus(RecordStatus.INACTIVE);
        return companyDocumentRepository.save(companyDocument);
    }
}
