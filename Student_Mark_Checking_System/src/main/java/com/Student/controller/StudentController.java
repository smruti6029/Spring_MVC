package com.Student.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;
import com.Student.service.GetStudentMarksByGmail;
import com.Student.service.InputStudent;
import com.Student.service.ReachingByStudent;
import com.Student.service.StudentInsertService;





@Controller
public class StudentController {
	
		
	@RequestMapping("/showresult")
	public String showResult()
	{
		return "entermail";
	}
	
		@Autowired
		private GetStudentMarksByGmail getStudentMarksByGmail;
	
			@RequestMapping(value = "/markBygmail" ,method = RequestMethod.POST)
			public ModelAndView studentmarkBygmail(@RequestParam("gmail") String gmail)
			{
			ModelAndView model =new ModelAndView();
			System.out.println(gmail);
			List<StudentResult> marks = getStudentMarksByGmail.getMarks(gmail);	
			
			
			model.addObject("gmail", gmail);
			model.addObject("marks",marks);
			model.setViewName("studentmark");
			return model;
			}
			
			
			@RequestMapping("/reachingApply")
			public String showRecheck(@RequestParam("gmail") String gmail,Model model)
			{
				model.addAttribute("gmail",gmail);
				
				return "reachingApply";
			}
			
			@Autowired
			private ReachingByStudent byStudent;
			@RequestMapping(value = "/recheck-form-data",method = RequestMethod.POST)
		public ModelAndView addReaching(@RequestParam("subjects") List<String> subjects,@RequestParam("gmail") String gmail) throws NumberFormatException, IOException
		{
			ModelAndView model= new ModelAndView();
			
			byStudent.reachingByStudent(gmail,subjects);
			
			
			
			model.setViewName("success");
			
			return model;
			
			
		}
			
			
			
			
			
			
			
			
}
