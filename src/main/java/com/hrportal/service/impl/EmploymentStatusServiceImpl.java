package com.hrportal.service.impl;

import com.hrportal.model.EmploymentStatus;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.EmploymentStatusRepository;
import com.hrportal.service.IEmploymentStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 20-09-2017.
 */
@Service
public class EmploymentStatusServiceImpl implements IEmploymentStatusService {

    @Autowired
    private EmploymentStatusRepository cmploymentStatusRepository;


    @Override
    public List<EmploymentStatus> getAll() {
        return cmploymentStatusRepository.findAll();
    }

    @Override
    public EmploymentStatus get(Long id) throws NotFoundException {
        EmploymentStatus cmploymentStatus = cmploymentStatusRepository.findOne(id);
        if (Objects.isNull(cmploymentStatus)) {
            throw new NotFoundException("EmploymentStatus Not found with given id : " + id);
        }
        return cmploymentStatus;
    }

    @Override
    public EmploymentStatus save(EmploymentStatus cmploymentStatus) {
        return cmploymentStatusRepository.save(cmploymentStatus);
    }

    @Override
    public EmploymentStatus update(Long id, EmploymentStatus cmploymentStatus) throws NotFoundException {
        if (!cmploymentStatusRepository.exists(cmploymentStatus.getId())) {
            throw new NotFoundException("EmploymentStatus Not found with given id : " + cmploymentStatus.getId());
        }
        return cmploymentStatusRepository.save(cmploymentStatus);
    }

    @Override
    public EmploymentStatus delete(Long id) throws NotFoundException {
        EmploymentStatus cmploymentStatus = cmploymentStatusRepository.findOne(id);
        if (!Objects.isNull(cmploymentStatus)) {
            throw new NotFoundException("EmploymentStatus Not found with given id : " + id);
        }
        cmploymentStatus.setRecordStatus(RecordStatus.INACTIVE);
        return cmploymentStatusRepository.save(cmploymentStatus);
    }
}
