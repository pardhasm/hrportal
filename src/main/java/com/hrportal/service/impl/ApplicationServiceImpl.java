package com.hrportal.service.impl;

import com.hrportal.model.Application;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.ApplicationRepository;
import com.hrportal.service.IApplicationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Application get(Long id) throws NotFoundException {
        Application call = applicationRepository.findOne(id);
        if (Objects.isNull(call)) {
            throw new NotFoundException("Application Not found with given id : " + id);
        }
        return call;
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application update(Long id, Application application) throws NotFoundException {
        if (!applicationRepository.exists(application.getId())) {
            throw new NotFoundException("Application Not found with given id : " + application.getId());
        }
        return applicationRepository.save(application);
    }

    @Override
    public Application delete(Long id) throws NotFoundException {
        Application application = applicationRepository.findOne(id);
        if (!Objects.isNull(application)) {
            throw new NotFoundException("Application Not found with given id : " + id);
        }
        application.setRecordStatus(RecordStatus.INACTIVE);
        return applicationRepository.save(application);
    }
}
