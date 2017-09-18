package com.hrportal.service;

import com.hrportal.model.User;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IUserService {

    List<User> getAll();

    User get(Long id) throws NotFoundException;

    User save(User user);

    User update(Long id, User user) throws NotFoundException;

    User delete(Long id) throws NotFoundException;
}
