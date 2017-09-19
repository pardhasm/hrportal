package com.hrportal.service.impl;

import com.hrportal.model.Call;
import com.hrportal.model.Employee;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmployeeRepository;
import com.hrportal.service.IEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(Long id) throws NotFoundException {
        Employee employee = employeeRepository.findOne(id);
        if (Objects.isNull(employee)) {
            throw new NotFoundException("Employee Not found with given id : " + id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) throws NotFoundException {
        if (!employeeRepository.exists(employee.getId())) {
            throw new NotFoundException("Employee Not found with given id : " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Long id) throws NotFoundException {
        Employee employee = employeeRepository.findOne(id);
        if (!Objects.isNull(employee)) {
            throw new NotFoundException("Employee Not found with given id : " + id);
        }
        employee.setRecordStatus(RecordStatus.INACTIVE);
        return employeeRepository.save(employee);
    }
}
