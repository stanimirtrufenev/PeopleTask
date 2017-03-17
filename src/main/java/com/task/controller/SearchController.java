package com.task.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.configuration.TaskConfig;
import com.task.daos.SearchDao;

@Controller
@ContextConfiguration(classes = TaskConfig.class)
public class SearchController {
	@Autowired
	private SearchDao searchDao;

	@RequestMapping(value="/SearchPerson", method = RequestMethod.POST)
	public String search(@RequestParam("name") String name, Model model) {
		
		ArrayList<String> list = searchDao.getPerson(name);
		if (list != null) {
			model.addAttribute("list", list);
		}
		return "person";
	}	
	
}
