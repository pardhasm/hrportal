package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.StatusChangeLog;
import com.hrportal.repository.StatusChangeLogRepository;
import com.hrportal.service.IStatusChangeLogService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Pardha Saradhi Mavilla
 */
@Service
public class StatusChangeLogServiceImpl implements IStatusChangeLogService {

    @Autowired
    private StatusChangeLogRepository statusChangeLogRepository;


    @Override
    public List<StatusChangeLog> getAll() {
        return statusChangeLogRepository.findAll();
    }

    @Override
    public StatusChangeLog get(Long id) throws NotFoundException {
        StatusChangeLog statusChangeLog = statusChangeLogRepository.findOne(id);
        if (Objects.isNull(statusChangeLog)) {
            throw new NotFoundException("StatusChangeLog Not found with given id : " + id);
        }
        return statusChangeLog;
    }

    @Override
    public StatusChangeLog save(StatusChangeLog statusChangeLog) {
        return statusChangeLogRepository.save(statusChangeLog);
    }

    @Override
    public StatusChangeLog update(Long id, StatusChangeLog statusChangeLog) throws NotFoundException {
        if (!statusChangeLogRepository.exists(statusChangeLog.getId())) {
            throw new NotFoundException("StatusChangeLog Not found with given id : " + statusChangeLog.getId());
        }
        return statusChangeLogRepository.save(statusChangeLog);
    }

    @Override
    public StatusChangeLog delete(Long id) throws NotFoundException {
        StatusChangeLog statusChangeLog = statusChangeLogRepository.findOne(id);
        if (!Objects.isNull(statusChangeLog)) {
            throw new NotFoundException("StatusChangeLog Not found with given id : " + id);
        }
        statusChangeLog.setRecordStatus(RecordStatus.INACTIVE);
        return statusChangeLogRepository.save(statusChangeLog);
    }
}
