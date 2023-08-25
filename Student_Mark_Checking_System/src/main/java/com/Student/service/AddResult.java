package com.Student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.Student.Dao.Result_DAO;
import com.Student.Dao.Student_DAO;
import com.Student.Dao.Subject_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.Entity.Subject;


@Service
public class AddResult {


	@Autowired
	Student_DAO studentDao;
	
	@Autowired
	Subject_DAO subjectDao ;
	
	@Autowired
	Result_DAO resultDao;
	
	

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public Boolean addStudentWiseResult(Map<String, Integer> marksStudent, String gmail) throws IOException {
		try
		{

		int flag = 1;
		boolean vallidUser = true;
		List<Subject> subject = subjectDao.getAllSubject();
	
		Student student = studentDao.getBygmail(gmail);

		List<StudentResult> allStudentResult = resultDao.getAll();
		if(allStudentResult!=null)
		{
		for (StudentResult student_res : allStudentResult) {
			System.out.println(student_res.getStudent().getId());
			System.out.println(student.getName()  +""+ student.getId());
			if (student_res.getStudent().getId() == student.getId()) {
					vallidUser = false;
				break;
			} else {
				vallidUser = true;
				System.out.println(vallidUser);
				break;
			}
		}
		}	

		if (vallidUser) {
			ArrayList<StudentResult> studentmarks = new ArrayList();
			if (student != null) {
				int marks=0;
				for (Subject s : subject) {
					for(String sub:marksStudent.keySet())
					{
						
						if(s.getSubject().equalsIgnoreCase(sub))
						{
							marks=marksStudent.get(sub);
					
					if (marks > 0 && marks < 100) {
						StudentResult obj = new StudentResult();
						obj.setMarks(marks);
						obj.setStudent(student);
						obj.setSubject(s);
						studentmarks.add(obj);
					} else {
						
						flag = 0;
						break;
					}

						}
				}
				}
			}
			if (flag != 0) {
				resultDao.addResult(studentmarks);
				
			}
			
		}

		else {
		return false;
		}
	
		}
		catch (NumberFormatException e) {
			return false;
			
		}
		return true;
			
		}
	}


