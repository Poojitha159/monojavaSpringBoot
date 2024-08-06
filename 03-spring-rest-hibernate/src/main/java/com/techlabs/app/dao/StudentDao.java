package com.techlabs.app.dao;

import java.util.List;

import com.techlabs.app.entity.Student;

public interface StudentDao {

	//public List<Student> getAllStudents();

//	public Student getStudentById();

	

	//public Student getStudentById(int id);

//	public Student save(Student student);

	public Student saveAndUpdate(Student student);

	public List<Student> getAllStudent();



	public Student getStudentById(int id);

	public void deleteStudent(Student student);
}
