package com.hrportal.service;

import com.hrportal.model.Email;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IEmailService {

    List<Email> getAll();

    Email get(Long id) throws NotFoundException;

    Email save(Email email);

    Email update(Long id, Email email) throws NotFoundException;

    Email delete(Long id) throws NotFoundException;
}
