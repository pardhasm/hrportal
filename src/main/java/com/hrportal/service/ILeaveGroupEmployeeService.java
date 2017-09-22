package com.hrportal.service;

import com.hrportal.model.LeaveGroupEmployee;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ILeaveGroupEmployeeService {

    List<LeaveGroupEmployee> getAll();

    LeaveGroupEmployee get(Long id) throws NotFoundException;

    LeaveGroupEmployee save(LeaveGroupEmployee leaveGroupEmployee);

    LeaveGroupEmployee update(Long id, LeaveGroupEmployee leaveGroupEmployee) throws NotFoundException;

    LeaveGroupEmployee delete(Long id) throws NotFoundException;
}
