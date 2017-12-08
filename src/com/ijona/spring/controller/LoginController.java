package com.ijona.spring.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class LoginController {
	
   
	@RequestMapping(value= {"/index",""},method = RequestMethod.GET)
	public String viewHome(ModelMap model, HttpServletRequest request) {
		
		return "index";
	}


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String viewIndexPage(ModelMap model) {
		
		return "home";
	}


		
}
