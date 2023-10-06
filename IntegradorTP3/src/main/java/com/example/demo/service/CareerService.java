package com.example.demo.service;

import com.example.demo.repository.CareerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.DTOCareerRequest;
import com.example.demo.DTO.DTOCareerResponse;
import com.example.demo.DTO.DTOCareerByStudents;
import com.example.demo.DTO.DTOCareerByYear;
import com.example.demo.model.Career;

@Service("careerService")
public class CareerService {
	@Autowired
	private CareerRepository repository;
	
	@Transactional
	public DTOCareerResponse save(DTOCareerRequest request) throws Exception {
		try {
			Career career = repository.save(new Career(request.getIdCareer(), request.getName()));
			return new DTOCareerResponse(career);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional( readOnly = true )
	public List<DTOCareerByStudents> getCareersByNumberOfStudents() throws Exception {
		try {
			return repository.getCareersByNumberOfStudents();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional( readOnly = true )
	public List<DTOCareerByYear> getReportOfCareers() throws Exception {
		try {
			return repository.getReportOfCareers();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional ( readOnly = true )
	public List<DTOCareerResponse> findAll() throws Exception {
		try {
			return repository.findAll().stream().map( DTOCareerResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
}
