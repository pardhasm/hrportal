package com.hrportal.service;

import com.hrportal.model.Job;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IJobService {

    List<Job> getAll();

    Job get(Long id) throws NotFoundException;

    Job save(Job job);

    Job update(Long id, Job job) throws NotFoundException;

    Job delete(Long id) throws NotFoundException;
}
