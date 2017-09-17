package com.hrportal.service;

import com.hrportal.model.Interview;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface IInterviewService {

    List<Interview> getAllInterviews();

    Interview getInterview(long id) throws NotFoundException;

    Interview save(Interview interview);

    Interview updateInterview(long id, Interview interview) throws NotFoundException;
}
