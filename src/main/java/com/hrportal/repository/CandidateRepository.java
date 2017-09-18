package com.hrportal.repository;


import com.hrportal.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate ,Long>{
}
