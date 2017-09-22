package com.hrportal.service;

import com.hrportal.model.LeaveRule;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ILeaveRuleService {

    List<LeaveRule> getAll();

    LeaveRule get(Long id) throws NotFoundException;

    LeaveRule save(LeaveRule leaveRule);

    LeaveRule update(Long id, LeaveRule leaveRule) throws NotFoundException;

    LeaveRule delete(Long id) throws NotFoundException;
}
