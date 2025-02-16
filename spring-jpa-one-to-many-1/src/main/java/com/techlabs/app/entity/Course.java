package com.techlabs.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	
	//@ManyToOne(targetEntity="course",fetch=FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="instructor_id")
	@JsonBackReference
	private Instructor instructor;

	
	
	public Course() {
		super();
	}



	public Course(int id, String name, int duration, Instructor instructor) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.instructor = instructor;
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



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
