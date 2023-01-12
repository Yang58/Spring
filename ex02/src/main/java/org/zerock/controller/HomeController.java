package org.zerock.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/*")
public class HomeController {
	
	
	@GetMapping("/index")
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	
}
