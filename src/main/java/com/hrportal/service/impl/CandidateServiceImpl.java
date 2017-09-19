package com.hrportal.service.impl;

import com.hrportal.model.Call;
import com.hrportal.model.Candidate;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.CandidateRepository;
import com.hrportal.service.ICandidateService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by pardha on 9/17/17.
 */
@Service
public class CandidateServiceImpl implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate get(Long id) throws NotFoundException {
        Candidate candidate = candidateRepository.findOne(id);
        if (Objects.isNull(candidate)) {
            throw new NotFoundException("Candidate Not found with given id : " + id);
        }
        return candidate;
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Long id, Candidate candidate) throws NotFoundException {
        if (!candidateRepository.exists(candidate.getId())) {
            throw new NotFoundException("Candidate Not found with given id : " + candidate.getId());
        }
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate delete(Long id) throws NotFoundException {
        Candidate candidate = candidateRepository.findOne(id);
        if (!Objects.isNull(candidate)) {
            throw new NotFoundException("Candidate Not found with given id : " + id);
        }
        candidate.setRecordStatus(RecordStatus.INACTIVE);
        return candidateRepository.save(candidate);
    }
}
