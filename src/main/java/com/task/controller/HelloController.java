package com.task.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.daos.CreateDao;



@Controller
public class HelloController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String sayHello() {
		return "index";
	}	
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String getTags(@RequestParam("name") String name,@RequestParam("pin") String pin,
			@RequestParam("addressType") String addressType,@RequestParam("addressInfo") String addressInfo,
			@RequestParam("emailType") String emailType,@RequestParam("email") String email) {
		System.out.println(name + "aaaaaaaaa");
		CreateDao createDao = new CreateDao();	
		
		System.out.println("REQUESTTT");
		createDao.create(name, pin, addressType, addressInfo, emailType, email);
		return "index";

	}	
	

}