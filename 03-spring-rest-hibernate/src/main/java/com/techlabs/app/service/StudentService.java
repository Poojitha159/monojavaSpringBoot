package com.techlabs.app.service;

import java.util.List;

import com.techlabs.app.entity.Student;

public interface StudentService {

	public Student saveAndUpdate(Student student);

	public List<Student> getAllStudent();



	public Student getStudentById(int id);

	public void deleteStudent(Student student);


}
