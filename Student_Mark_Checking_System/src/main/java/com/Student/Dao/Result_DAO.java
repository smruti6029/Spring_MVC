package com.Student.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.Entity.Subject;

@Repository
@Transactional
public class Result_DAO {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int addResult(ArrayList<StudentResult> studentmarks) {
		
		
		
		for(StudentResult s:studentmarks)
		{
//			System.out.println(s.getStudent().getId());
//			System.out.println(s.getStudent().getName());
			hibernateTemplate.save(s);	
			
		}
		return 0;
		
	}
	
	public List<StudentResult> getresultByStudent(int student_id) {

		List<StudentResult> students = (List<StudentResult>) hibernateTemplate
				.findByNamedParam("from StudentResult where student_id = :student_id", "student_id", student_id);

		return students;
	}

	public List<StudentResult> getAll() {

		return hibernateTemplate.loadAll(StudentResult.class);
	}
	public void update(StudentResult recheck)
	
	{
//		System.out.println("inside recheck");
		StudentResult studentResult = hibernateTemplate.get(StudentResult.class,recheck.getId());
//		System.out.println(studentResult.get_Is_active());
		
		studentResult.setIs_active(true);
//		System.out.println(studentResult.get_Is_active());
		
		
		hibernateTemplate.update(studentResult);
		
	}
	public void updateStudent(StudentResult recheckDone)
	{
//		System.out.println("inside Update student");
		StudentResult studentResult = hibernateTemplate.get(StudentResult.class,recheckDone.getId());
		
//		System.out.println("inside ");
		
//		System.out.println(studentResult.getStudent().getEmail());
		
//		System.out.println(recheckDone.get_Is_active());
		
		studentResult.setIs_active(recheckDone.get_Is_active());
//		System.out.println(recheckDone.getMarks());
//		
		studentResult.setMarks(recheckDone.getMarks());
//		
		hibernateTemplate.update(studentResult);
//		
//		System.out.println("Marks Updated"+recheckDone.getSubject().getSubject());
		
		
	}

	public StudentResult getResultId(int resid) {
		try
		{
			StudentResult studentResult = hibernateTemplate.get(StudentResult.class,resid);
				
		
		return studentResult;
		}
		catch (Exception e) {
//			System.out.println("No Matter");
			return null;
		}
	}

}


//public int update(Employ employ) {
//	try
//	{
//	hibernateTemplate.update(employ);
//		return 1;
//	}
//	catch(Exception e)
//	{
//		System.out.println("Employ Don't Exit");
//		return 0;
//	}






