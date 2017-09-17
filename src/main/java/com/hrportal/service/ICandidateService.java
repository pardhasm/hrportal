package com.hrportal.service;

import com.hrportal.model.Candidate;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by pardha on 9/17/17.
 */
public interface ICandidateService {
    List<Candidate> getAllCandidates();

    Candidate getCandidate(long id) throws NotFoundException;

    Candidate save(Candidate candidate);

    Candidate updateCandidate(long id, Candidate candidate) throws NotFoundException;
}
