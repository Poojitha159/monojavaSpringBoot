package com.techlabs.app.dto;

import java.util.Set;

import com.techlabs.app.entity.Course;

public class StudentDTO {

	private int id;
	private String name;
	private String email;
	private Set<CourseDTO> course;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(int id, String name, String email, Set<CourseDTO> course) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<CourseDTO> getCourse() {
		return course;
	}
	public void setCourse(Set<CourseDTO> course) {
		this.course = course;
	}

	
	
	
	
}
