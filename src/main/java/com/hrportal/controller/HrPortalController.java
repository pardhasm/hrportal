package com.hrportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrportal.model.Candidate;

@RestController
@RequestMapping("/Candidate")
public class HrPortalController {
	
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Candidate> getAllCandidates(){
		
		
		return null;
	}
	
	@RequestMapping(value="/{candidateId}",method=RequestMethod.GET)
	public Candidate getCandidateDetails(@PathVariable("candidateid")long id){
		return null;
		
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public long insertCandidate(@RequestBody Candidate candidate){
		return 0;
		
	}

	@RequestMapping(value="/update/{candidateId}",method=RequestMethod.PUT)
	public long UpdateCandidate(@RequestBody Candidate candidate){
		return 0;
		
	}
	
	
}
