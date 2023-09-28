package com.example.demo.repository;

import java.sql.Date;

import com.example.demo.model.Carrer;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class StudentHistoryRepositoryImpl implements StudentHistoryRepository {
	private static StudentHistoryRepositoryImpl instance;
	private EntityManager em;
	
	private StudentHistoryRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}
	
	public static StudentHistoryRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new StudentHistoryRepositoryImpl();
		}
		return instance;
	}
	
	@Override
	public void graduateStudent(Student student, Carrer carrer) {
		try {
			TypedQuery<StudentHistory> query = this.em.createQuery("SELECT sr FROM StudentHistory sr WHERE sr.student = ?1 AND sr.career = ?2", StudentHistory.class);
			query.setParameter(1, student);
			query.setParameter(2, carrer);
			StudentHistory sr = query.getSingleResult();
			
			Date current_date = new Date(System.currentTimeMillis());
			this.em.getTransaction().begin();
			sr.setEgressDate(current_date);
			this.em.merge(sr);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insertStudentToCareer(Carrer carrer, Student student) {
		long miliSeconds = System.currentTimeMillis();
		Date date = new Date(miliSeconds);
		StudentHistory studentHistory = new StudentHistory(student, carrer, date, null, false);
		try {
			em.getTransaction().begin();
			if(!em.contains(studentHistory)) {
				em.persist(studentHistory);
			}else {
				em.merge(studentHistory);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
