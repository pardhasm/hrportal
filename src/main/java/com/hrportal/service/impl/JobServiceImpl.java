package com.hrportal.service.impl;

import com.hrportal.model.Job;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.JobRepository;
import com.hrportal.service.IJobService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobRepository jobRepository;


    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job get(Long id) throws NotFoundException {
        Job job = jobRepository.findOne(id);
        if (Objects.isNull(job)) {
            throw new NotFoundException("Job Not found with given id : " + id);
        }
        return job;
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job update(Long id, Job job) throws NotFoundException {
        if (!jobRepository.exists(job.getId())) {
            throw new NotFoundException("Job Not found with given id : " + job.getId());
        }
        return jobRepository.save(job);
    }

    @Override
    public Job delete(Long id) throws NotFoundException {
        Job job = jobRepository.findOne(id);
        if (!Objects.isNull(job)) {
            throw new NotFoundException("Call Not found with given id : " + id);
        }
        job.setRecordStatus(RecordStatus.INACTIVE);
        return jobRepository.save(job);
    }


}
