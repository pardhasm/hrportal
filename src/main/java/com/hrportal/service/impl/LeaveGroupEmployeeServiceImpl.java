package com.hrportal.service.impl;

import com.hrportal.model.LeaveGroupEmployee;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.LeaveGroupEmployeeRepository;
import com.hrportal.service.ILeaveGroupEmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class LeaveGroupEmployeeServiceImpl implements ILeaveGroupEmployeeService {

    @Autowired
    private LeaveGroupEmployeeRepository leaveGroupEmployeeRepository;


    @Override
    public List<LeaveGroupEmployee> getAll() {
        return leaveGroupEmployeeRepository.findAll();
    }

    @Override
    public LeaveGroupEmployee get(Long id) throws NotFoundException {
        LeaveGroupEmployee leaveGroupEmployee = leaveGroupEmployeeRepository.findOne(id);
        if (Objects.isNull(leaveGroupEmployee)) {
            throw new NotFoundException("LeaveGroupEmployee Not found with given id : " + id);
        }
        return leaveGroupEmployee;
    }

    @Override
    public LeaveGroupEmployee save(LeaveGroupEmployee leaveGroupEmployee) {
        return leaveGroupEmployeeRepository.save(leaveGroupEmployee);
    }

    @Override
    public LeaveGroupEmployee update(Long id, LeaveGroupEmployee leaveGroupEmployee) throws NotFoundException {
        if (!leaveGroupEmployeeRepository.exists(leaveGroupEmployee.getId())) {
            throw new NotFoundException("LeaveGroupEmployee Not found with given id : " + leaveGroupEmployee.getId());
        }
        return leaveGroupEmployeeRepository.save(leaveGroupEmployee);
    }

    @Override
    public LeaveGroupEmployee delete(Long id) throws NotFoundException {
        LeaveGroupEmployee leaveGroupEmployee = leaveGroupEmployeeRepository.findOne(id);
        if (!Objects.isNull(leaveGroupEmployee)) {
            throw new NotFoundException("LeaveGroupEmployee Not found with given id : " + id);
        }
        leaveGroupEmployee.setRecordStatus(RecordStatus.INACTIVE);
        return leaveGroupEmployeeRepository.save(leaveGroupEmployee);
    }
}
