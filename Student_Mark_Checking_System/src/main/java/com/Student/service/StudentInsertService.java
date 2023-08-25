package com.Student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Dao.Student_DAO;
import com.Student.Entity.Student;


@Service
public class StudentInsertService {
	
	
	@Autowired
	private Student_DAO studentdao;
	public void insert(Student student)
	{
		int insert = this.studentdao.insert(student);
		System.out.println("Insert Succesfullty");
		
	}

}
