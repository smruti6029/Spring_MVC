package com.Student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Student.Dao.Student_DAO;
import com.Student.Entity.*;

@Service
public class InputStudent {
	
	
	@Autowired
	private Student_DAO dao;
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void inputStudent(Student student) 
	
	{
		Student bygmail = dao.getBygmail(student.getEmail());
		if (bygmail == null) {

		
			int insert = dao.insert(student);
			System.out.println("Student Insert Successfully");
		} else {
			System.out.println("Student already exit");
		}

	}
}
