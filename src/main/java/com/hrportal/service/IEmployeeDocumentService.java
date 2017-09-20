package com.hrportal.service;

import com.hrportal.model.EmployeeDocument;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
public interface IEmployeeDocumentService {

    List<EmployeeDocument> getAll();

    EmployeeDocument get(Long id) throws NotFoundException;

    EmployeeDocument save(EmployeeDocument employeeDocument);

    EmployeeDocument update(Long id, EmployeeDocument employeeDocument) throws NotFoundException;

    EmployeeDocument delete(Long id) throws NotFoundException;
}
