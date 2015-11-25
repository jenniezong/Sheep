package com.nan.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index.html") 
	public ModelAndView index() {
		
//		ModelAndView mav = new ModelAndView("/main");
//		String url = "/login";
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("layout", "true");
		
    	return new ModelAndView("layout/default","layout","false");
	}
}
