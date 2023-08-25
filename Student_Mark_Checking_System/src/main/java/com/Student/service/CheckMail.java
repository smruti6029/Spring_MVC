package com.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Dao.Student_DAO;
import com.Student.Entity.Student;
import com.Student.Entity.Subject;


@Service
public class CheckMail {
	
	@Autowired
	Student_DAO studentDao;
	
	public boolean checkStudent(String gmail)
	{
		
	Student student = studentDao.getBygmail(gmail);
	
	if(student!=null)
	{
		return true;
	}
	else
	{
		return false;
	}
	
	}

}
