package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import com.techlabs.app.dto.CourseDTO;
import com.techlabs.app.dto.StudentDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;

public interface StudentCourseService {

	StudentDTO saveStudent(StudentDTO student);

	List<StudentDTO> getAllStudents();

	Optional<StudentDTO> getStudentById(int id);

	void deleteStudent(int id);

	CourseDTO saveCourse(CourseDTO course);

	List<CourseDTO> getAllCourses();
	
	Optional<CourseDTO> getCourseById(int id);

	void deleteCourse(Integer id);

	StudentDTO addStudentToCourse(int studentId, int courseId);

	StudentDTO removeStudentFromCourse(int studentId, int courseId);

}
