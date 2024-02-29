package com.ckk.springbootproject.daos;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ckk.springbootproject.models.Student;

@Repository
public class ApiDao {
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	public List<Student> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student", Student.class);
		List<Student> list = query.getResultList();
		
		return list;
	}

}
