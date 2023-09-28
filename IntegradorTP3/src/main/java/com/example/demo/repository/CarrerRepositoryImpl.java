package com.example.demo.repository;

import java.util.List;

import com.example.demo.DTO.DTOCarrerByStudents;
import com.example.demo.DTO.DTOCarrerByYear;
import com.example.demo.model.Carrer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarrerRepositoryImpl{
	private static CarrerRepositoryImpl instance;
	private EntityManager em;
	
	private CarrerRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}
	
	public static CarrerRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new CarrerRepositoryImpl();
		}
		return instance;
	}


	public void insertCarrer(Carrer career) {
		try {
			em.getTransaction().begin();
			if(!em.contains(career)) {
				em.persist(career);
			}else {
				em.merge(career);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	public List<DTOCarrerByStudents> getCarrersByNumberOfStudents() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOCareerByStudents(c.name, COUNT(c.name))"
					+ " FROM Career c"
					+ " JOIN c.students s"
					+ " GROUP BY c.name"
					+ " HAVING COUNT(c.name) > 0"
					+ " ORDER BY COUNT(c.name) DESC";
			Query query = em.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<DTOCarrerByStudents> carres = query.getResultList();
			em.getTransaction().commit();
			return carres;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")

	public List<DTOCarrerByYear> getReportOfCarrers() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOCareerByYear(c.idCareer, c.name, COUNT(sr.inscriptionDate), COUNT(sr.egressDate), year(sr.inscriptionDate)) FROM StudentHistory sr JOIN sr.career c GROUP BY c.idCareer, c.name, year(sr.inscriptionDate) ORDER BY c.name, year(sr.inscriptionDate)";
			Query query = em.createQuery(jpql);
			List<DTOCarrerByYear> career = query.getResultList();
			em.getTransaction().commit();
			return career;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
}
