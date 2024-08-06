package com.techlabs.app.dto;

public class CourseDTO {
	private Long id;
	private String title;
	
	public CourseDTO(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	
	public CourseDTO() {
		
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
