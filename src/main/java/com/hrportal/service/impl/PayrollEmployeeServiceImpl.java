package com.hrportal.service.impl;

import com.hrportal.model.PayrollEmployee;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.PayrollEmployeeRepository;
import com.hrportal.service.IPayrollEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class PayrollEmployeeServiceImpl implements IPayrollEmployeeService {

    @Autowired
    private PayrollEmployeeRepository payrollEmployeeRepository;


    @Override
    public List<PayrollEmployee> getAll() {
        return payrollEmployeeRepository.findAll();
    }

    @Override
    public PayrollEmployee get(Long id) throws NotFoundException {
        PayrollEmployee payrollEmployee = payrollEmployeeRepository.findOne(id);
        if (Objects.isNull(payrollEmployee)) {
            throw new NotFoundException("PayrollEmployee Not found with given id : " + id);
        }
        return payrollEmployee;
    }

    @Override
    public PayrollEmployee save(PayrollEmployee payrollEmployee) {
        return payrollEmployeeRepository.save(payrollEmployee);
    }

    @Override
    public PayrollEmployee update(Long id, PayrollEmployee payrollEmployee) throws NotFoundException {
        if (!payrollEmployeeRepository.exists(payrollEmployee.getId())) {
            throw new NotFoundException("PayrollEmployee Not found with given id : " + payrollEmployee.getId());
        }
        return payrollEmployeeRepository.save(payrollEmployee);
    }

    @Override
    public PayrollEmployee delete(Long id) throws NotFoundException {
        PayrollEmployee payrollEmployee = payrollEmployeeRepository.findOne(id);
        if (!Objects.isNull(payrollEmployee)) {
            throw new NotFoundException("PayrollEmployee Not found with given id : " + id);
        }
        payrollEmployee.setRecordStatus(RecordStatus.INACTIVE);
        return payrollEmployeeRepository.save(payrollEmployee);
    }
}
