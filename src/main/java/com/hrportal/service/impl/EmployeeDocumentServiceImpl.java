package com.hrportal.service.impl;

import com.hrportal.model.EmployeeDocument;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeDocumentRepository;
import com.hrportal.service.IEmployeeDocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeDocumentServiceImpl implements IEmployeeDocumentService {

    @Autowired
    private EmployeeDocumentRepository employeeDocumentRepository;


    @Override
    public List<EmployeeDocument> getAll() {
        return employeeDocumentRepository.findAll();
    }

    @Override
    public EmployeeDocument get(Long id) throws NotFoundException {
        EmployeeDocument employeeDocument = employeeDocumentRepository.findOne(id);
        if (Objects.isNull(employeeDocument)) {
            throw new NotFoundException("EmployeeDocument Not found with given id : " + id);
        }
        return employeeDocument;
    }

    @Override
    public EmployeeDocument save(EmployeeDocument employeeDocument) {
        return employeeDocumentRepository.save(employeeDocument);
    }

    @Override
    public EmployeeDocument update(Long id, EmployeeDocument employeeDocument) throws NotFoundException {
        if (!employeeDocumentRepository.exists(employeeDocument.getId())) {
            throw new NotFoundException("EmployeeDocument Not found with given id : " + employeeDocument.getId());
        }
        return employeeDocumentRepository.save(employeeDocument);
    }

    @Override
    public EmployeeDocument delete(Long id) throws NotFoundException {
        EmployeeDocument employeeDocument = employeeDocumentRepository.findOne(id);
        if (!Objects.isNull(employeeDocument)) {
            throw new NotFoundException("EmployeeDocument Not found with given id : " + id);
        }
        employeeDocument.setRecordStatus(RecordStatus.INACTIVE);
        return employeeDocumentRepository.save(employeeDocument);
    }
}
