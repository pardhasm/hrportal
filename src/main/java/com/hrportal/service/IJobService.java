package com.hrportal.service;

import com.hrportal.model.Job;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IJobService {

    List<Job> getAllJobs();

    Job getJob(long id) throws NotFoundException;

    Job save(Job job);

    Job updateJob(long id, Job job) throws NotFoundException;
}
