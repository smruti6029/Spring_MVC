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
import com.Student.Entity.StudentResult;



@Service
public class SeeallRechecking {

	
	@Autowired
	private Result_DAO resultDao ;
	BufferedReader bf;
	

	public List<StudentResult> updateRequest()  {

		boolean flag = false;
		List<StudentResult> AllSubresult = resultDao.getAll();
		
		return AllSubresult;
	}
}
		
//		int check = 0;
//
//		for (StudentResult result : AllSubresult) {
//			
//			try
//			{
//			if(result.get_Is_active()!=null)
//			{
//			if (result.get_Is_active() == true) {
//				if (result.getStudent().getId() != check) {
//					System.out.println("__________________________________");
//					System.out.println("Reching Apply For Student");
//					System.out.println("Name  - " + result.getStudent().getName());
//					System.out.println("Gmail - " + result.getStudent().getEmail());
//					check = result.getStudent().getId();
//				}
//
//				System.out.println("Subject - " + result.getSubject().getSubject());
//				System.out.println("Marks   - " + result.getMarks());
//				System.out.println("_________________________________");
//				flag = true;
//
//			}
//			}
//		}
//			catch (Exception e) {
//				
//			}
//		}
//		if (flag) {
//			while (true) {
//				System.out.println("Enter 1 to up Date Mark");
//				System.out.println("Enter 2 to Exit");
//				int input = Integer.parseInt(bf.readLine());
//
//				if (input == 1) {
//					System.out.println("Enter Gmail Id");
//					String gmailId = bf.readLine();
//					UpdateStudentMark st = new UpdateStudentMark();
//					st.updateStudent(gmailId);
//				}
//				if (input == 2) {
//					break;
//				}
//
//			}
//		} else {
//			System.out.println("No Recheckin found");
//		}
//
//		return null;
//
//	}
//}
