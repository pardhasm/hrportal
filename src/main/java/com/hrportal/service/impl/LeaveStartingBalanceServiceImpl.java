package com.hrportal.service.impl;

import com.hrportal.model.LeaveStartingBalance;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.LeaveStartingBalanceRepository;
import com.hrportal.service.ILeaveStartingBalanceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class LeaveStartingBalanceServiceImpl implements ILeaveStartingBalanceService {

    @Autowired
    private LeaveStartingBalanceRepository leaveStartingBalanceRepository;


    @Override
    public List<LeaveStartingBalance> getAll() {
        return leaveStartingBalanceRepository.findAll();
    }

    @Override
    public LeaveStartingBalance get(Long id) throws NotFoundException {
        LeaveStartingBalance leaveStartingBalance = leaveStartingBalanceRepository.findOne(id);
        if (Objects.isNull(leaveStartingBalance)) {
            throw new NotFoundException("LeaveStartingBalance Not found with given id : " + id);
        }
        return leaveStartingBalance;
    }

    @Override
    public LeaveStartingBalance save(LeaveStartingBalance leaveStartingBalance) {
        return leaveStartingBalanceRepository.save(leaveStartingBalance);
    }

    @Override
    public LeaveStartingBalance update(Long id, LeaveStartingBalance leaveStartingBalance) throws NotFoundException {
        if (!leaveStartingBalanceRepository.exists(leaveStartingBalance.getId())) {
            throw new NotFoundException("LeaveStartingBalance Not found with given id : " + leaveStartingBalance.getId());
        }
        return leaveStartingBalanceRepository.save(leaveStartingBalance);
    }

    @Override
    public LeaveStartingBalance delete(Long id) throws NotFoundException {
        LeaveStartingBalance leaveStartingBalance = leaveStartingBalanceRepository.findOne(id);
        if (!Objects.isNull(leaveStartingBalance)) {
            throw new NotFoundException("LeaveStartingBalance Not found with given id : " + id);
        }
        leaveStartingBalance.setRecordStatus(RecordStatus.INACTIVE);
        return leaveStartingBalanceRepository.save(leaveStartingBalance);
    }
}
