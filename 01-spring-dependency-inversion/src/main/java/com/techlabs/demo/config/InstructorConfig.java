package com.techlabs.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.techlabs.demo.model.Instructor;
import com.techlabs.demo.model.JavaInstructor;
import com.techlabs.demo.model.PythonInstructor;
@Configuration
public class InstructorConfig {
	
	@Bean(name="pythonInstructor")
	public Instructor getPythonInstructorBean() {
		return new PythonInstructor();
		
	}
	
 	@Bean(name="javaInstructor")
	@Primary
	@Scope("prototype")
	public Instructor getJythonInstructorBean() {
		return new JavaInstructor();
		
	}

}
