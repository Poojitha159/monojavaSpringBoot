package com.techlabs.demo.dao;

import java.util.List;

import com.techlabs.demo.entity.Student;

public interface StudentDao {
	public void save(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int i);

	public List<Student> getStudentByFirstName(String string);

	public List<Student> getStudentsByFirstNameandLastName(String string, String string2);

	

	public void updateStudent(Student student);

	public void deleteStudent(int i);

	public void updateStudentW(Student student);

	

	public void deleteAllStudents(int i);

	public void deleteStudentsLessthanThree(int i);

	

	


}
