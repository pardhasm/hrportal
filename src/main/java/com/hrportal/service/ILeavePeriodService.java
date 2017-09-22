package com.hrportal.service;

import com.hrportal.model.LeavePeriod;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ILeavePeriodService {

    List<LeavePeriod> getAll();

    LeavePeriod get(Long id) throws NotFoundException;

    LeavePeriod save(LeavePeriod leavePeriodall);

    LeavePeriod update(Long id, LeavePeriod leavePeriodall) throws NotFoundException;

    LeavePeriod delete(Long id) throws NotFoundException;
}
