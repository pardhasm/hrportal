package com.hrportal.service;

import com.hrportal.model.StatusChangeLog;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Pardha Saradhi Mavilla
 */
public interface IStatusChangeLogService {

    List<StatusChangeLog> getAll();

    StatusChangeLog get(Long id) throws NotFoundException;

    StatusChangeLog save(StatusChangeLog statusChangeLog);

    StatusChangeLog update(Long id, StatusChangeLog statusChangeLog) throws NotFoundException;

    StatusChangeLog delete(Long id) throws NotFoundException;
}
