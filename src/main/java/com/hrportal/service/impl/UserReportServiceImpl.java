package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.UserReport;
import com.hrportal.repository.UserReportRepository;
import com.hrportal.service.IUserReportService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Pardha Saradhi Mavilla
 */
@Service
public class UserReportServiceImpl implements IUserReportService {

    @Autowired
    private UserReportRepository userReportRepository;


    @Override
    public List<UserReport> getAll() {
        return userReportRepository.findAll();
    }

    @Override
    public UserReport get(Long id) throws NotFoundException {
        UserReport user = userReportRepository.findOne(id);
        if (Objects.isNull(user)) {
            throw new NotFoundException("UserReport Not found with given id : " + id);
        }
        return user;
    }

    @Override
    public UserReport save(UserReport user) {
        return userReportRepository.save(user);
    }

    @Override
    public UserReport update(Long id, UserReport user) throws NotFoundException {
        if (!userReportRepository.exists(user.getId())) {
            throw new NotFoundException("UserReport Not found with given id : " + user.getId());
        }
        return userReportRepository.save(user);
    }

    @Override
    public UserReport delete(Long id) throws NotFoundException {
        UserReport user = userReportRepository.findOne(id);
        if (!Objects.isNull(user)) {
            throw new NotFoundException("UserReport Not found with given id : " + id);
        }
        user.setRecordStatus(RecordStatus.INACTIVE);
        return userReportRepository.save(user);
    }
}
