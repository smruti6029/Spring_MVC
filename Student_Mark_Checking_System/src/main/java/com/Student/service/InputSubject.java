package com.Student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.Student.Dao.Subject_DAO;
import com.Student.Entity.Subject;

@Service
public class InputSubject {

	@Autowired
	private Subject_DAO dao;

	public void inputSubject(ArrayList<String> subjects) {
		
		
		for(String sub:subjects)
		{
			Subject subjectAdd=new Subject();
			subjectAdd.setSubject(sub);
			dao.insertSubject(subjectAdd);
		}
		

	}
}
