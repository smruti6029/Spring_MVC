package com.spring.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.entity.User;






@Controller
public class Test {
	
	@RequestMapping("/show")
	public String show(Model model) {
		System.out.println("Inside Show");
		

		
		model.addAttribute("name", "DELL");
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("DELL");
		names.add("HP");
		names.add("Lenovo");
		names.add("Asus");
		
		
		model.addAttribute("names", names);
		
		return "index";
	}
	
	@RequestMapping("/form")
	public String form()
	{
		return "form";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(User user,Model model)
	{
		model.addAttribute("name",user.getUserName());

		
		return "registerd";
	}
	
}
