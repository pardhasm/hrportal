package com.hrportal.service.impl;

import com.hrportal.model.EmployeeCompanyLoan;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeCompanyLoanRepository;
import com.hrportal.service.IEmployeeCompanyLoanService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmployeeCompanyLoanServiceImpl implements IEmployeeCompanyLoanService {

    @Autowired
    private EmployeeCompanyLoanRepository employeeCompanyLoanRepository;


    @Override
    public List<EmployeeCompanyLoan> getAll() {
        return employeeCompanyLoanRepository.findAll();
    }

    @Override
    public EmployeeCompanyLoan get(Long id) throws NotFoundException {
        EmployeeCompanyLoan employeeCompanyLoan = employeeCompanyLoanRepository.findOne(id);
        if (Objects.isNull(employeeCompanyLoan)) {
            throw new NotFoundException("EmployeeCompanyLoan Not found with given id : " + id);
        }
        return employeeCompanyLoan;
    }

    @Override
    public EmployeeCompanyLoan save(EmployeeCompanyLoan call) {
        return employeeCompanyLoanRepository.save(call);
    }

    @Override
    public EmployeeCompanyLoan update(Long id, EmployeeCompanyLoan employeeCompanyLoan) throws NotFoundException {
        if (!employeeCompanyLoanRepository.exists(employeeCompanyLoan.getId())) {
            throw new NotFoundException("EmployeeCompanyLoan Not found with given id : " + employeeCompanyLoan.getId());
        }
        return employeeCompanyLoanRepository.save(employeeCompanyLoan);
    }

    @Override
    public EmployeeCompanyLoan delete(Long id) throws NotFoundException {
        EmployeeCompanyLoan employeeCompanyLoan = employeeCompanyLoanRepository.findOne(id);
        if (!Objects.isNull(employeeCompanyLoan)) {
            throw new NotFoundException("EmployeeCompanyLoan Not found with given id : " + id);
        }
        employeeCompanyLoan.setRecordStatus(RecordStatus.INACTIVE);
        return employeeCompanyLoanRepository.save(employeeCompanyLoan);
    }

}
