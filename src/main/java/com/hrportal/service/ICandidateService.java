package com.hrportal.service;

import com.hrportal.model.Candidate;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by pardha on 9/17/17.
 */
public interface ICandidateService {
    List<Candidate> getAll();

    Candidate get(Long id) throws NotFoundException;

    Candidate save(Candidate candidate);

    Candidate update(Long id, Candidate candidate) throws NotFoundException;

    Candidate delete(Long id) throws NotFoundException;
}
