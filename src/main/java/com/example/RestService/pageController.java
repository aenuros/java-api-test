package com.example.RestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {
	//gets html from a default 'resources/public' or 'resources/static' folder
	  @RequestMapping("/home")
	  public ModelAndView getWelcomePageAsModel() {
	      ModelAndView modelAndView = new ModelAndView();
	      modelAndView.setViewName("index.html");
	      return modelAndView;
	  }
}

