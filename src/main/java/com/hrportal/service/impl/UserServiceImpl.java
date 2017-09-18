package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.User;
import com.hrportal.repository.UserRepository;
import com.hrportal.service.IUserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) throws NotFoundException {
        User user = userRepository.findOne(id);
        if (Objects.isNull(user)) {
            throw new NotFoundException("User Not found with given id : " + id);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) throws NotFoundException {
        if (!userRepository.exists(user.getId())) {
            throw new NotFoundException("User Not found with given id : " + user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) throws NotFoundException {
        User user = userRepository.findOne(id);
        if (!Objects.isNull(user)) {
            throw new NotFoundException("User Not found with given id : " + id);
        }
        user.setRecordStatus(RecordStatus.INACTIVE);
        return userRepository.save(user);
    }
}
