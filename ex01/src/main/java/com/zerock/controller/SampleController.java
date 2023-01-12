package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zerock.domain.SampleDTO;
import com.zerock.domain.SampleDTOList;
import com.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("SampleData");
	}
	
	// get방식의 요청을 처리하는 에너테이션
	@GetMapping("ex01")
	public String ex01(SampleDTO dto){ 
		// 커멘드 객체 or 커멘드 클래스 
		//	 1. 파라미터 자동으로 받기 
		// 	 2. 뷰 페이지로 커맨드 객체의 정보를 전달 ( 클래스의 첫 글자를 소문자로 변경해서 전달 =>sampleDTO )
		// DTO에 정의된 변수의 이름과 쿼리스트링으로 넘어온 변수명의 이름이 같다면 자동으로 연결 시켜준다 
		log.info("" + dto);
		return "ex01";
	}
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age){ 
		log.info(name);
		log.info(age);
		return "ex02";
	}
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids){ 
		log.info("ids : " + ids);
		
		return "ex02List";
	}
	@GetMapping("ex02Bean")
	public String ex02List(SampleDTOList list){ 
		log.info("list : " + list);
		
		return "ex02Bean";
	}
	@GetMapping("ex03")
	public String ex3(TodoDTO todo){ 
		log.info("todo : " + todo);
		
		return "ex03";
	}
	
	@GetMapping("ex04")
	public String ex04(SampleDTO dto , @ModelAttribute("page") int page){
		// 커멘드 객체 or 커멘드 클래스 
		//	 1. 파라미터 자동으로 받기 
		// 	 2. 뷰 페이지로 커맨드 객체의 정보를 전달 ( 클래스의 첫 글자를 소문자로 변경해서 전달  => sampleDTO )
		// 	 3. 기본형 매개변수에 대해 뷰페이지로  값 전달을 위해 @ModelAttribute를 사용한다. 
		// 		@ModelAttribute : 강제로 전달 받은 파라미터를 Model에 담아 전달해야할 때 필요한 어노테이션 
		//							타입에 관계없이 무조건 Model에 담아서 전달되므로 , 파라미터로 전달된 데이터를 다시 화면에서 사용해야 할때 유용하게 사용 
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "ex04";
	}
	
	@GetMapping("ex06")
	public @ResponseBody SampleDTO ex06() {
		
		SampleDTO dto = new SampleDTO();
		dto.setName("H");
		dto.setAge(10);
		
		return dto;
	}
	
	@GetMapping("ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07");
		
		String msg = "{\"name\" : \"Hong\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json; charset=UTF-8");
		return new ResponseEntity<>(msg, header , HttpStatus.OK);
	}
	
	
}
