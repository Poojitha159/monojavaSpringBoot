package com.techlabs.app.service;

import java.util.List;

import com.techlabs.app.entity.Student;

public interface StudentService {
	public List<Student> getAllStuddents() ;
	public Student getStudentById(int id);
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public Student saveAndUpdate(Student student);
	public  void deleteStudent(int id);
	public void deleteStudent(Student student);

}
