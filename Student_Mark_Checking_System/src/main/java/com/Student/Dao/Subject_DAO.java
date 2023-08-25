package com.Student.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.Student.Entity.Subject;

@Repository
@Transactional
public class Subject_DAO {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	public int insertSubject(Subject subject) {
		int i = (Integer) hibernateTemplate.save(subject);

		return i;
	}

	public List<Subject> getAllSubject() {

		return hibernateTemplate.loadAll(Subject.class);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public  Subject get(int id)
	{
		Subject subject=hibernateTemplate.get(Subject.class,id);
		return subject;
		
	}
	
	
}


//public Employ getId(int id)
//{
//	Employ employ = hibernateTemplate.
//	return employ;
//}
