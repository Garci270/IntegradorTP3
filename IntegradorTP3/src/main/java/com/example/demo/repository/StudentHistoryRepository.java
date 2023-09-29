package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;

@Repository("studentHistoryRepository")
public interface StudentHistoryRepository extends JpaRepository<StudentHistory, Integer> { //StudenHistoryPK en vez de Integer???
//	@Query
//	public void graduateStudent(Student student, Career carrer);
}
