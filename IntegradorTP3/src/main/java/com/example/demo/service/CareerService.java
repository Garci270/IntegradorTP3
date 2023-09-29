package com.example.demo.service;

import com.example.demo.repository.CareerRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			throw new Exception();
		}
	}
	
	@Transactional
	public List<DTOCareerByStudents> getCareersByNumberOfStudents() throws Exception {
		try {
			var rows = repository.getCareersByNumberOfStudents();
			return rows.stream()
				.map(row -> new DTOCareerByStudents(row.getName(), row.getAmountStudents()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public List<DTOCareerByYear> getReportOfCareers() throws Exception {
		try {
			var rows = repository.getReportOfCareers();
			return rows.stream()
					.map(row -> new DTOCareerByYear(row.getIdCareer(), row.getName(), row.getAmountEnrolled(), row.getAmountGraduated(), row.getYear()))
						.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
}
