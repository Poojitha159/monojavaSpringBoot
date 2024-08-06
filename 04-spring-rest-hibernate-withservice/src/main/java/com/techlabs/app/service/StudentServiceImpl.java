package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techlabs.app.entity.Student;
import com.techlabs.app.repository.StudentRepository;

import jakarta.persistence.EntityManager;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentReposity;
	
	public StudentServiceImpl(StudentRepository studentReposity) {
		super();
		this.studentReposity = studentReposity;
	}

	@Override
	public List<Student> getAllStuddents() {
		
		return studentReposity.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> byId = studentReposity.findById(id);
		if(byId.isPresent()) return byId.get();
		return null;
	}

	
	@Override
	public Student addStudent(Student student) {
		
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		return null;
	}

	@Override
	public Student saveAndUpdate(Student student) {
		
		return studentReposity.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentReposity.deleteById(id);
		
	}

	@Override
	public void deleteStudent(Student student) {
		studentReposity.delete(student);
		
	}

	

}
