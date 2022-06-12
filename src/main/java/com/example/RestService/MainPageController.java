package com.example.RestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainPageController {
	
	
	@GetMapping("")
	public ModelAndView viewHomePage() {
		ModelAndView view = new ModelAndView("/RestService/src/main/resources/templates/index.html");
		return view;
	}
	
}
