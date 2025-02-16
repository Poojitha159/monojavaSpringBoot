package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Instructor;

public interface InstructorService {

	List<Instructor> findAllInstructors();

	Instructor saveInstructor(Instructor instructor);

	

	Instructor getInstructorByid(int id);

	void deleteById(Instructor instructor);

	

	boolean removeCourseFromInstructor(int instructorId, int courseId);

	Instructor addCoursetoInstructor(int id, int courseId);

	
}
