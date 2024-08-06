package com.techlabs.app.controller;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

//import com.techlabs.app.dao.StudentDao;
import com.techlabs.app.entity.Student;
import com.techlabs.app.exception.StudentErrorResponse;
import com.techlabs.app.exception.StudentNotFoundException;
import com.techlabs.app.service.StudentService;

@RestController
public class StudentController  {

	//private StudentDao studentDao;
	private StudentService studentDao;

	public StudentController(StudentService studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStuddents() {

		List<Student> student=studentDao.getAllStuddents();
		//return studentDao.getAllStudent();
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}

	@GetMapping("/students/{sid}")
	public Student getStudentById(@PathVariable(name = "sid") int id) throws StudentNotFoundException {

		Student student = studentDao.getStudentById(id);
if(student==null) {
	throw new StudentNotFoundException("student not found with ID"+id);
}
		return student;
	}

	@PostMapping("/students")

	public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student) {
		student.setId(0);
		Student ustudent1=studentDao.saveAndUpdate(student);
		//return studentDao.saveAndUpdate(student1);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student tempStudent = studentDao.getStudentById(student.getId());
		if (tempStudent==null) {
			throw new RuntimeException("student not found with ID "+student.getId());
		}
			
		Student updatedstudent=studentDao.saveAndUpdate(student);
			return new ResponseEntity<Student>(updatedstudent,HttpStatus.CREATED);

		

	}

	@DeleteMapping("/students/{sid}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable(name="sid") int id) {
		
		Student student=studentDao.getStudentById(id);
		if(student==null) {
	
			throw new StudentNotFoundException("Student with ID "+id+"not found");
		}
		studentDao.deleteStudent(student);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
	
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now());

	    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
	
		System.out.println( "Exception Handler");
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now());

	    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
	
}