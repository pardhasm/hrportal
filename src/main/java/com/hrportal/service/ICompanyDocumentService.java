package com.hrportal.service;

import com.hrportal.model.CompanyDocument;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface ICompanyDocumentService {

    List<CompanyDocument> getAll();

    CompanyDocument get(Long id) throws NotFoundException;

    CompanyDocument save(CompanyDocument companyDocument);

    CompanyDocument update(Long id, CompanyDocument companyDocument) throws NotFoundException;

    CompanyDocument delete(Long id) throws NotFoundException;

}
