package com.Student.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.Student.Dao.Result_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;


@Service
public class GetAllStudentGrade {

	
	@Autowired
	private Result_DAO resultDao;
	

	public List<StudentResult> getAllStudentMark() {

		System.out.println("enter here");
		List<StudentResult> allStudent = resultDao.getAll();
		System.out.println(allStudent);
		return allStudent;
		
	}
}
		
//		Map<String, Map<String, Integer>> student = new TreeMap<>();
//		
//		Map<String, Integer> subject = new HashMap<>();
//
//		for (StudentResult s : allStudent) {
//			String subjectName = s.getSubject().getSubject();
//			int marks = s.getMarks();
//
//			if (student.containsKey(s.getStudent().getName())) {
//
//				Map<String, Integer> existingSubjectMarks = student.get(s.getStudent().getName());
//
//				existingSubjectMarks.put(subjectName, marks);
//			} else {
//
//				Map<String, Integer> newSubjectMarks = new HashMap<>();
//				newSubjectMarks.put(subjectName, marks);
//
//				student.put(s.getStudent().getName(), newSubjectMarks);
//			}
//		}

//		
//		for (String StudentName : student.keySet()) {
//			double mark = 0;
//			ArrayList<Integer> allMarks = new ArrayList<>();
//			
//			
//			Map<String, Integer> map = student.get(StudentName);
//			System.out.println("______________________________________________");
//			System.out.println("Name     :-  " + StudentName);
//			System.out.println("                     ");
//			for (String sub : map.keySet()) {
//				System.out.println("Subject  -  " + sub + " - Mark -  " + map.get(sub));
//				System.out.println("........................................");
//				mark += map.get(sub);
//				allMarks.add(map.get(sub));
//			}
//
//			Double percentage = mark / 6;
//			String calculateGrade = calculateGrade(percentage, allMarks);
//			
//				
//		}
//
//	}
//				public static String calculateGrade(double percentage, ArrayList<Integer> marks) {
//			
//					for (Integer m : marks) {if (m < 30) {return "F";}}
//					
//					double mark = percentage;
//					if (mark > 30 && mark < 40) {
//						return "D";
//					} else if (mark >= 40 && mark <= 60) {
//						return "C";
//					} else if (mark >= 60 && mark <= 80) {
//						return "B";
//					} else if (mark >= 80 && mark <= 90) {
//						return "A2";
//					} else if (mark >= 80 && mark <= 100) {
//						return "A1";
//					} else {
//			
//						return "F";
//					}
//				}
//				
//
////}
