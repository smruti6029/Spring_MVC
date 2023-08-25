package com.Student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.service.AddResult;
import com.Student.service.CheckMail;
import com.Student.service.GetAllStudentGrade;
import com.Student.service.InputStudent;
import com.Student.service.InputSubject;
import com.Student.service.SeeallRechecking;
import com.Student.service.UpdateStudentMark;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private InputSubject inputSubject;

	@RequestMapping("/add")
	public String show() {

		return "insertAdmin";
	}

	@RequestMapping(path = "/firstPage", method = RequestMethod.POST)
	public ModelAndView handle(@RequestParam("gmail") String gmail, @RequestParam("name") String name) {
		ModelAndView model = new ModelAndView();
		model.addObject("name", name);
		model.addObject("gmail", gmail);

		if (name.equalsIgnoreCase("smruti")) {
			model.setViewName("addMinPage");

		} else {
			model.setViewName("fallid");
		}

		return model;
	}

	@RequestMapping("/subject")
	public String show1() {
		return "addSubject";
	}

	@RequestMapping(path = "/add-subject", method = RequestMethod.POST)
	public ModelAndView addSubject(@RequestParam("subject1") String subject1, @RequestParam("subject2") String subject2,
			@RequestParam("subject3") String subject3, @RequestParam("subject4") String subject4,
			@RequestParam("subject5") String subject5, @RequestParam("subject6") String subject6) {
		ModelAndView model = new ModelAndView();
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);
		subjects.add(subject4);
		subjects.add(subject5);
		subjects.add(subject6);

		inputSubject.inputSubject(subjects);

		model.setViewName("meassegeSuccess");

		return model;
	}

	@Autowired
	private InputStudent inputStudent;

	@RequestMapping("/studentAdd")
	public String stdentAddByadmin() {
		return "signin";
	}

	@RequestMapping(path = "/studentInsert", method = RequestMethod.POST)
	public ModelAndView handleStudent(@RequestParam("gmail") String gmail, @RequestParam("name") String name) {
		ModelAndView model = new ModelAndView();
		model.addObject("name", name);
		model.addObject("gmail", gmail);

		Student student = new Student();
		student.setName(name);
		student.setEmail(gmail);
		inputStudent.inputStudent(student);

		model.setViewName("success");

		return model;
	}

	@RequestMapping("/result")
	public String checkMailId() {

		return "addResult";
	}

	@Autowired
	private CheckMail checkMail;

	@RequestMapping(path = "/addResult", method = RequestMethod.POST)
	public ModelAndView checkMail(@RequestParam("gmail") String gmail) {
		ModelAndView model = new ModelAndView();

		boolean checkStudent = checkMail.checkStudent(gmail);

		if (checkStudent) 
		{
			model.addObject("gmail",gmail);
			model.setViewName("resultInsert");
			return model;
		} 
		else {
			System.out.println("fallid");
			return model;
		}

		
	}
	
	
	@Autowired
	private AddResult addResult;
	
	@RequestMapping(path = "/processingMark", method = RequestMethod.POST)
	public ModelAndView resultAdd(@RequestParam("Java") Integer subject1, @RequestParam("C") Integer subject2,
			@RequestParam("React") Integer subject3, @RequestParam("DBMS") Integer subject4,
			@RequestParam("OS") Integer subject5, @RequestParam("Python") Integer subject6,@RequestParam("gmail") String gmail) throws IOException
{
		ModelAndView model = new ModelAndView();
		ArrayList<Integer> subjects = new ArrayList<>();
		
		
		Map<String,Integer> marks=new HashMap<>();
		
		marks.put("Java", subject1);
		marks.put("C", subject2);
		marks.put("Recat", subject3);
		marks.put("DBMS", subject4);
		marks.put("OS", subject5);
		marks.put("Python", subject6);
		
		Boolean addStudentWiseResult = addResult.addStudentWiseResult(marks,gmail);
		if(addStudentWiseResult)
		{
		model.setViewName("success");
		}
		else
		{
			model.setViewName("fallid");
			
			return model;
		}
		
		return model;
	}
	
	
	@Autowired
	private  GetAllStudentGrade allStudentGrade;
	
	@RequestMapping("/showAllData")
	public ModelAndView showAllData()
	{
		
		ModelAndView model =new ModelAndView();
		
		
		System.out.println("Inside Integer");
		
		
	
		List<StudentResult> allStudentMark = allStudentGrade.getAllStudentMark();
		
		
		System.out.println("Inside Integer");
		model.addObject("get",allStudentMark);
		
		model.setViewName("viewAllStudentDetalis");
		return model;
	}
	
	
	@Autowired
	private SeeallRechecking rechecking;
	
	@RequestMapping(value = "/showApplyForResult",method = RequestMethod.GET)
	public ModelAndView showApplyForResult()
	{
		
		
		
			ModelAndView model =new ModelAndView();
			List<StudentResult> AllSubresult = rechecking.updateRequest();
			model.addObject("AllSubresult", AllSubresult);
		
			model.setViewName("allstudent");
			
		
		return model;
		
	}
	
	@RequestMapping("gmail")
	public ModelAndView showGmailLogin()
	{
		ModelAndView model= new ModelAndView(); 
		
		model.setViewName("gmail");
		
		return model;
	}
	
	
	
	@RequestMapping(value = "/updateStudentmark",method = RequestMethod.POST)
	public ModelAndView getMAil(@RequestParam("gmail") String gmail)
	{
		
					System.out.println(gmail);
		
			ModelAndView model =new ModelAndView();	
		
			model.addObject("gmail",gmail);
			
			model.setViewName("updateStudentmark");
			
		
		return model;
		
	}
	
	
	@Autowired
	private UpdateStudentMark updateMark; 
	
	@RequestMapping("/updateMark")
	public ModelAndView update(@RequestParam("gmail") String gmail,@RequestParam("subject") String subject,@RequestParam("mark") Integer mark)
	{
		
		System.out.println(gmail);
		
			ModelAndView model =new ModelAndView();	
		
	
			model.addObject("gmail",gmail);
			
			Boolean updateStudent = updateMark.updateStudent(gmail, subject, mark);
			
			model.setViewName("updateStudentmark");
			
		
		return model;
		
	}
	
	

			
	
	}

	
	
	
	


