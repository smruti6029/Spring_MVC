package com.Student.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Student.Entity.Student;
import com.Student.Entity.Subject;

@Repository
@Transactional
public class Student_DAO {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	public int insert(Student student) {
		int i = (Integer) hibernateTemplate.save(student);

		return i;
	}

	public Student getBygmail(String email) {
		
		try
		{
		List<Student> students = (List<Student>) hibernateTemplate.findByNamedParam("from Student where email = :email",
				"email", email);
		
//				System.out.println(students);
		return students.get(0);
		}
		catch(Exception e)
		{
			return null;
		}

	}

	public List<Student> getAll() {

		return hibernateTemplate.loadAll(Student.class);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
