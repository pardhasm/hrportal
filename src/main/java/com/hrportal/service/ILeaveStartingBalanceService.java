package com.hrportal.service;

import com.hrportal.model.LeaveStartingBalance;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ILeaveStartingBalanceService {

    List<LeaveStartingBalance> getAll();

    LeaveStartingBalance get(Long id) throws NotFoundException;

    LeaveStartingBalance save(LeaveStartingBalance leaveStartingBalance);

    LeaveStartingBalance update(Long id, LeaveStartingBalance leaveStartingBalance) throws NotFoundException;

    LeaveStartingBalance delete(Long id) throws NotFoundException;
}
