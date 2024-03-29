package com.hrportal.service.impl;

import com.hrportal.model.Call;
import com.hrportal.model.Interview;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.InterviewRepository;
import com.hrportal.service.IInterviewService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Service
public class InterviewServiceImpl implements IInterviewService {

    @Autowired
    private InterviewRepository interviewRepository;


    @Override
    public List<Interview> getAll() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview get(Long id) throws NotFoundException {
        Interview interview = interviewRepository.findOne(id);
        if (Objects.isNull(interview)) {
            throw new NotFoundException("Interview Not found with given id : " + id);
        }
        return interview;
    }

    @Override
    public Interview save(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interview update(Long id, Interview interview) throws NotFoundException {
        if (!interviewRepository.exists(interview.getId())) {
            throw new NotFoundException("Interview Not found with given id : " + interview.getId());
        }
        return interviewRepository.save(interview);
    }

    @Override
    public Interview delete(Long id) throws NotFoundException {
        Interview interview = interviewRepository.findOne(id);
        if (!Objects.isNull(interview)) {
            throw new NotFoundException("Call Not found with given id : " + id);
        }
        interview.setRecordStatus(RecordStatus.INACTIVE);
        return interviewRepository.save(interview);
    }
}
