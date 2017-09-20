package com.hrportal.service;

import com.hrportal.model.UserReport;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Pardha Saradhi Mavilla
 */
public interface IUserReportService {

    List<UserReport> getAll();

    UserReport get(Long id) throws NotFoundException;

    UserReport save(UserReport user);

    UserReport update(Long id, UserReport user) throws NotFoundException;

    UserReport delete(Long id) throws NotFoundException;
}
