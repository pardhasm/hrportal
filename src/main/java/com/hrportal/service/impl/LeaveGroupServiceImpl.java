package com.hrportal.service.impl;

import com.hrportal.model.LeaveGroup;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.LeaveGroupRepository;
import com.hrportal.service.ILeaveGroupService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class LeaveGroupServiceImpl implements ILeaveGroupService {

    @Autowired
    private LeaveGroupRepository leaveGroupRepository;


    @Override
    public List<LeaveGroup> getAll() {
        return leaveGroupRepository.findAll();
    }

    @Override
    public LeaveGroup get(Long id) throws NotFoundException {
        LeaveGroup leaveGroup = leaveGroupRepository.findOne(id);
        if (Objects.isNull(leaveGroup)) {
            throw new NotFoundException("LeaveGroup Not found with given id : " + id);
        }
        return leaveGroup;
    }

    @Override
    public LeaveGroup save(LeaveGroup leaveGroup) {
        return leaveGroupRepository.save(leaveGroup);
    }

    @Override
    public LeaveGroup update(Long id, LeaveGroup leaveGroup) throws NotFoundException {
        if (!leaveGroupRepository.exists(leaveGroup.getId())) {
            throw new NotFoundException("LeaveGroup Not found with given id : " + leaveGroup.getId());
        }
        return leaveGroupRepository.save(leaveGroup);
    }

    @Override
    public LeaveGroup delete(Long id) throws NotFoundException {
        LeaveGroup leaveGroup = leaveGroupRepository.findOne(id);
        if (!Objects.isNull(leaveGroup)) {
            throw new NotFoundException("LeaveGroup Not found with given id : " + id);
        }
        leaveGroup.setRecordStatus(RecordStatus.INACTIVE);
        return leaveGroupRepository.save(leaveGroup);
    }
}
