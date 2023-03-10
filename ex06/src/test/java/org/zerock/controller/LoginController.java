package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/login/*")
@AllArgsConstructor
public class LoginController {

	@RequestMapping("/main")
	public String mainView() {
		
		return "/login/loginMain";
	}
	
	
}
