package com.hrportal.service.impl;

import com.hrportal.model.EmployeeApproval;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeApprovalRepository;
import com.hrportal.service.IEmployeeApprovalService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class EmployeeApprovalServiceImpl implements IEmployeeApprovalService {

    @Autowired
    private EmployeeApprovalRepository employeeApprovalRepository;


    @Override
    public List<EmployeeApproval> getAll() {
        return employeeApprovalRepository.findAll();
    }

    @Override
    public EmployeeApproval get(Long id) throws NotFoundException {
        EmployeeApproval employeeApproval = employeeApprovalRepository.findOne(id);
        if (Objects.isNull(employeeApproval)) {
            throw new NotFoundException("EmployeeApproval Not found with given id : " + id);
        }
        return employeeApproval;
    }

    @Override
    public EmployeeApproval save(EmployeeApproval employeeApproval) {
        return employeeApprovalRepository.save(employeeApproval);
    }

    @Override
    public EmployeeApproval update(Long id, EmployeeApproval employeeApproval) throws NotFoundException {
        if (!employeeApprovalRepository.exists(employeeApproval.getId())) {
            throw new NotFoundException("EmployeeApproval Not found with given id : " + employeeApproval.getId());
        }
        return employeeApprovalRepository.save(employeeApproval);
    }

    @Override
    public EmployeeApproval delete(Long id) throws NotFoundException {
        EmployeeApproval employeeApproval = employeeApprovalRepository.findOne(id);
        if (!Objects.isNull(employeeApproval)) {
            throw new NotFoundException("EmployeeApproval Not found with given id : " + id);
        }
        employeeApproval.setRecordStatus(RecordStatus.INACTIVE);
        return employeeApprovalRepository.save(employeeApproval);
    }
}
