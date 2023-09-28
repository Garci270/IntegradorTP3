package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Carrer;
import com.example.demo.DTO.DTOCarrerByStudents;
import com.example.demo.DTO.DTOCarrerByYear;

public interface CarrerRepository extends JpaRepository<Carrer, Integer>{
	public void insertCarrer(Carrer career);
	public List<DTOCarrerByStudents> getCarrersByNumberOfStudents();
	public List<DTOCarrerByYear> getReportOfCarrers();
}
