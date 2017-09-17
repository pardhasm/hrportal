package com.hrportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrportal.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate ,Long>{
	
	
	public Candidate findById(long id);
	
	public List<Candidate> findAll();
	
	
	

}
