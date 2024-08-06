package com.techlabs.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.demo.model.Instructor;

@RestController
//@RequestMapping("/test")
public class TestController {
	private Instructor instructor1;
	private Instructor instructor2;
	
	@Value(value="${myapp.collagename}")
	private String collageName;

	
	public TestController(Instructor instructor1, Instructor instructor2) {
		super();
		this.instructor1 = instructor1;
		this.instructor2 = instructor2;
	}
	@GetMapping("/hello")
	public String getMessage() {
		return "Is singleton:"+instructor1.equals(instructor2)+"  ,  "+collageName;
		//return "My clg name is "+collageName;
		
	}
	@GetMapping("/greet")
	public String getGreetins() {
		return "Good Morning";
	}
	
	

}
