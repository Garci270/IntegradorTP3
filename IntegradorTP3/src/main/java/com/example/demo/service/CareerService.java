package com.example.demo.service;

import com.example.demo.repository.CareerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.DTOCareerByStudents;
import com.example.demo.DTO.DTOCareerByYear;
import com.example.demo.model.Career;

@Service("careerService")
public class CareerService {
	@Autowired
	private CareerRepository repository;
	
	@Transactional
	public Career save(Career career) throws Exception {
		try {
			return repository.save(career);
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
	
	
}
