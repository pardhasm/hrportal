package com.hrportal.service.impl;

import com.hrportal.model.LeavePeriod;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.LeavePeriodRepository;
import com.hrportal.service.ILeavePeriodService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class LeavePeriodServiceImpl implements ILeavePeriodService {

    @Autowired
    private LeavePeriodRepository leavePeriodRepository;


    @Override
    public List<LeavePeriod> getAll() {
        return leavePeriodRepository.findAll();
    }

    @Override
    public LeavePeriod get(Long id) throws NotFoundException {
        LeavePeriod leavePeriod = leavePeriodRepository.findOne(id);
        if (Objects.isNull(leavePeriod)) {
            throw new NotFoundException("LeavePeriod Not found with given id : " + id);
        }
        return leavePeriod;
    }

    @Override
    public LeavePeriod save(LeavePeriod leavePeriod) {
        return leavePeriodRepository.save(leavePeriod);
    }

    @Override
    public LeavePeriod update(Long id, LeavePeriod leavePeriod) throws NotFoundException {
        if (!leavePeriodRepository.exists(leavePeriod.getId())) {
            throw new NotFoundException("LeavePeriod Not found with given id : " + leavePeriod.getId());
        }
        return leavePeriodRepository.save(leavePeriod);
    }

    @Override
    public LeavePeriod delete(Long id) throws NotFoundException {
        LeavePeriod leavePeriod = leavePeriodRepository.findOne(id);
        if (!Objects.isNull(leavePeriod)) {
            throw new NotFoundException("LeavePeriod Not found with given id : " + id);
        }
        leavePeriod.setRecordStatus(RecordStatus.INACTIVE);
        return leavePeriodRepository.save(leavePeriod);
    }
}
