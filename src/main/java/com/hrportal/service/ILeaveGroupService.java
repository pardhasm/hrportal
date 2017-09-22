package com.hrportal.service;

import com.hrportal.model.LeaveGroup;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ILeaveGroupService {

    List<LeaveGroup> getAll();

    LeaveGroup get(Long id) throws NotFoundException;

    LeaveGroup save(LeaveGroup leaveGroup);

    LeaveGroup update(Long id, LeaveGroup leaveGroup) throws NotFoundException;

    LeaveGroup delete(Long id) throws NotFoundException;
}
