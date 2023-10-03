package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Career;
import com.example.demo.DTO.DTOCareerByStudents;
import com.example.demo.DTO.DTOCareerByYear;

@Repository("careerRepository")
public interface CareerRepository extends JpaRepository<Career, Integer>{

	@Query("SELECT c.name, COUNT(c.name)"
			+ " FROM Career c"
			+ " JOIN c.students s"
			+ " GROUP BY c.name"
			+ " HAVING COUNT(c.name) > 0"
			+ " ORDER BY COUNT(c.name) DESC")
	public List<DTOCareerByStudents> getCareersByNumberOfStudents();
	

	@Query("SELECT c.idCareer, c.name, COUNT(sr.inscriptionDate), COUNT(sr.egressDate), year(sr.inscriptionDate)"
			+ " FROM StudentHistory sr"
			+ " JOIN sr.career c"
			+ " GROUP BY c.idCareer, c.name, year(sr.inscriptionDate)"
			+ " ORDER BY c.name, year(sr.inscriptionDate)")
	public List<DTOCareerByYear> getReportOfCareers();
	
	@Query("SELECT c FROM Career c WHERE c.idCareer = :id")
	public Career getCareerById(long id);
	
	
	
}
