package com.hrportal.service.impl;

import com.hrportal.model.Job;
import com.hrportal.repository.JobRepository;
import com.hrportal.service.IJobService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobRepository jobRepository;


    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(long id) throws NotFoundException {
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
    public Job updateJob(long id, Job job) throws NotFoundException {
        if (!jobRepository.exists(job.getId())) {
            throw new NotFoundException("Job Not found with given id : " + job.getId());
        }
        return jobRepository.save(job);
    }


}
