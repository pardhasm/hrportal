package com.hrportal.service.impl;

import com.hrportal.model.Email;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmailRepository;
import com.hrportal.service.IEmailService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private EmailRepository emailRepository;


    @Override
    public List<Email> getAll() {
        return emailRepository.findAll();
    }

    @Override
    public Email get(Long id) throws NotFoundException {
        Email email = emailRepository.findOne(id);
        if (Objects.isNull(email)) {
            throw new NotFoundException("Email Not found with given id : " + id);
        }
        return email;
    }

    @Override
    public Email save(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Email update(Long id, Email email) throws NotFoundException {
        if (!emailRepository.exists(email.getId())) {
            throw new NotFoundException("Email Not found with given id : " + email.getId());
        }
        return emailRepository.save(email);
    }

    @Override
    public Email delete(Long id) throws NotFoundException {
        Email email = emailRepository.findOne(id);
        if (!Objects.isNull(email)) {
            throw new NotFoundException("Email Not found with given id : " + id);
        }
        email.setRecordStatus(RecordStatus.INACTIVE);
        return emailRepository.save(email);
    }


}
