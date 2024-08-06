package com.techlabs.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.demo.model.Instructor;

@RestController
public class InstructorController {
	//@Autowired
	//@Qualifier(value="javaInstructor")
	private Instructor instructor;
	
	
	public InstructorController(@Qualifier(value="javaInstructor") Instructor instructor) {
		super();
		this.instructor = instructor;
	}

	@Autowired
	@Qualifier(value="pythonInstructor")
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	

	@GetMapping("/trainPlan")
	public String getTrainingPlan() {
		
		return this.instructor.getTrainingPlan()+"<br>"+this.instructor.getResource();
	}


	

	

}
