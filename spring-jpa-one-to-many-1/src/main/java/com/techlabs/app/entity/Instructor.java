package com.techlabs.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table; 

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="instructor" ,orphanRemoval=false,cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	
	@JsonManagedReference
	private  List<Course> course;

	public Instructor() {
		super();
	}

	public Instructor(int id, String name, String email, List<Course> course) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
	}

	public void addCourse(Course course) {
		this.course.add(course);
		course.setInstructor(null);
	}
	public void removeCourse(Course course) {
		this.course.remove(course);
		course.setInstructor(null);
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

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + "]";
	}


	
}
