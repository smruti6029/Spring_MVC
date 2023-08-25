package com.Student.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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


@Service
public class GetStudentMarksByGmail {

	
	@Autowired
	private Result_DAO resultDao ;
	
	@Autowired
	private Student_DAO studentDao;
	
	@Autowired
	private Subject_DAO subjectDao ;

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public List<StudentResult> getMarks(String gmail) {

		try
		{
		Student student = studentDao.getBygmail(gmail);
		
		System.out.println(student.getName());

		List<StudentResult> AllSubresult = resultDao.getresultByStudent(student.getId());
		return AllSubresult;
		
		}
		catch (Exception e) {
			return null;
		}
	}
		
//		ArrayList<Integer> marks = new ArrayList();
//		double mark = 0;
//
//		if (AllSubresult != null) {
//
//			for (StudentResult res : AllSubresult) {
//				mark += res.getMarks();
//				marks.add(res.getMarks());
//			}
//			Double percentage = (mark / 6);
//			String Grade = StudentGrade.calculateGrade(percentage, marks);
//			System.out.println("______________________________________");
//			System.out.println("Name Of The Student :-" + student.getName());
//			System.out.println("gmail Of the Student :-" + student.getEmail());
//			System.out.println("Student Roll No :" + student.getId());
//			
//			System.out.println("_________________________________________");
//
//			AllSubresult.forEach(rs -> {
//				System.out.println(rs.getSubject().getSubject());
//				try {
//				if(rs.get_Is_active()==true)
//				{
//				System.out.println("Marks" + rs.getMarks());
//				System.out.println("--------------------------");
//				}
//				}
//				catch(Exception e)
//				{
//					
//				}
//				if(rs.get_Is_active()==null)
//				{
//					System.out.println("Marks" + rs.getMarks());
//					System.out.println("--------------------------");
//					
//				}
//				try
//				{
//				if(rs.get_Is_active()==false)
//				{
//					System.out.println(" * Marks " + rs.getMarks());
//					System.out.println("--------------------------");	
//				}
//				}
//				catch (Exception e) {
//					
//				}
//
//			});
//			System.out.println("Total Marks :-" + mark);
//			System.out.println("Grade :-" + Grade);
//			DecimalFormat decimalFormat = new DecimalFormat("#.00");
//			System.out.println("Percentage :-" + decimalFormat.format(percentage));
//			System.out.println("------------------------");
//
//		} else {
//			System.out.println("Invalid Credentials");
//		}
//		}
//		else
//		{
//			System.out.println("invalid Email");
//			System.out.println("Try Again");
//		}
//	}

}
