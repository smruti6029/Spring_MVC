package com.Student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.Student.Dao.Result_DAO;
import com.Student.Dao.Student_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;


@Service
public class UpdateStudentMark {

	
	@Autowired
	private Result_DAO resultDao;
	
	@Autowired
	private Student_DAO studentDao;
	

	

	public Boolean updateStudent(String mail,String subject,Integer mark) {

		Student student = studentDao.getBygmail(mail);
		
		

		if (student != null) {

			List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());

			for (StudentResult result : AllSubresult) {
				try
				{
				if (result.get_Is_active() == true) {
					
					if(result.getSubject().getSubject().equalsIgnoreCase(subject))
					{
					
					StudentResult obj = new StudentResult();
					obj.setId(result.getId());
					obj.setIs_active(false);
					obj.setMarks(mark);
					resultDao.updateStudent(obj);
					break;
					}

				}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			return true;

		} else {
			return false;
		}

	}
	
	
}
