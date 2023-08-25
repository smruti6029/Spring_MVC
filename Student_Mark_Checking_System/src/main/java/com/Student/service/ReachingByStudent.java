package com.Student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Service
public class ReachingByStudent {

	@Autowired
	private Student_DAO studentDao;

	@Autowired
	private Subject_DAO subjectDao;

	@Autowired
	private Result_DAO resultDao;

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void reachingByStudent(String gmailId, List<String> subjects) throws NumberFormatException, IOException {

		Student student = studentDao.getBygmail(gmailId);
//		ArrayList<String> showSubject = showSubject(student,subjects);
		ArrayList<String> showSubject=(ArrayList<String>) subjects;
		if (student != null) {

			List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());

			for (String subject_name : showSubject) {
				String sub = subject_name;
				int subject_id = 0;
				int resId = 0;

				for (StudentResult v : AllSubresult) {

					if (v.getSubject().getSubject().equalsIgnoreCase(sub)) {
						resId = v.getId();
						subject_id = v.getSubject().getId();
						
					}
				}

				Subject subject = subjectDao.get(subject_id);
				if (subject != null) {

					StudentResult resultId = resultDao.getResultId(resId);

					StudentResult obj = new StudentResult();
					obj.setId(resultId.getId());
					obj.setStudent(student);
					obj.setSubject(subject);
					resultDao.update(obj);
				} else {
					System.out.println("Try again");
				}
				

			}
		}
	}

	
}
