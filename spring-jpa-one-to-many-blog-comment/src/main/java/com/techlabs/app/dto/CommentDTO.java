package com.techlabs.app.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDTO {

	private int id;

	// @NotBlank(message = "Description is required")
	private String description;
	
	

	public CommentDTO(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}



	public CommentDTO() {
		System.out.println("commentDTO");
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", description=" + description + "]";
	}

}
