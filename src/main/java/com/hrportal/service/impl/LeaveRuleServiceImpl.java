package com.hrportal.service.impl;

import com.hrportal.model.LeaveRule;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.LeaveRuleRepository;
import com.hrportal.service.ILeaveRuleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class LeaveRuleServiceImpl implements ILeaveRuleService {

    @Autowired
    private LeaveRuleRepository leaveRuleRepository;


    @Override
    public List<LeaveRule> getAll() {
        return leaveRuleRepository.findAll();
    }

    @Override
    public LeaveRule get(Long id) throws NotFoundException {
        LeaveRule leaveRule = leaveRuleRepository.findOne(id);
        if (Objects.isNull(leaveRule)) {
            throw new NotFoundException("LeaveRule Not found with given id : " + id);
        }
        return leaveRule;
    }

    @Override
    public LeaveRule save(LeaveRule leaveRule) {
        return leaveRuleRepository.save(leaveRule);
    }

    @Override
    public LeaveRule update(Long id, LeaveRule leaveRule) throws NotFoundException {
        if (!leaveRuleRepository.exists(leaveRule.getId())) {
            throw new NotFoundException("LeaveRule Not found with given id : " + leaveRule.getId());
        }
        return leaveRuleRepository.save(leaveRule);
    }

    @Override
    public LeaveRule delete(Long id) throws NotFoundException {
        LeaveRule leaveRule = leaveRuleRepository.findOne(id);
        if (!Objects.isNull(leaveRule)) {
            throw new NotFoundException("LeaveRule Not found with given id : " + id);
        }
        leaveRule.setRecordStatus(RecordStatus.INACTIVE);
        return leaveRuleRepository.save(leaveRule);
    }
}
