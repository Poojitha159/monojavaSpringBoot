package com.techlabs.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.app.dto.CourseDTO;
import com.techlabs.app.dto.StudentDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;
import com.techlabs.app.service.StudentCourseService;

@RestController
@RequestMapping("/api")

public class StudentCourseController {
	
	private StudentCourseService studentCourseService;

	public StudentCourseController(StudentCourseService studentCourseService) {
		super();
		this.studentCourseService = studentCourseService;
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
		//return studentCourseService.saveStudent(student);
		if(student.getCourse()==null) {
			student.setCourse(new HashSet<>());
		}
		StudentDTO savedStudent=studentCourseService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
	
	@GetMapping("/students")
	public List<StudentDTO> getAllStudents(){
		return studentCourseService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Optional<StudentDTO>> getStudentById(@PathVariable int id){
		Optional<StudentDTO> student=studentCourseService.getStudentById(id);
		
		return ResponseEntity.ok(student);
		//return student.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id){
		studentCourseService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
	
	// ---Course end points
	
	@PostMapping("/courses")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {
      //  return studentCourseService.saveCourse(course);
		CourseDTO savedCourse=studentCourseService.saveCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @GetMapping("/courses")
    public List<CourseDTO> getAllCourses() {
        return studentCourseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable int id) {
        Optional<CourseDTO> course = studentCourseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
    	studentCourseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
//---- relationship
    //adding student to course
    @PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentDTO> addStudentToCourse(@PathVariable int studentId,@PathVariable int courseId){
    	StudentDTO student=studentCourseService.addStudentToCourse(studentId,courseId);
    	return student!=null ? ResponseEntity.ok(student):ResponseEntity.notFound().build();
    }
    //removing student from course
    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentDTO> removeStudentFromCourse(@PathVariable int studentId,@PathVariable int courseId){
    	StudentDTO student=studentCourseService.removeStudentFromCourse(studentId,courseId);
    	return student!=null ? ResponseEntity.ok(student):ResponseEntity.notFound().build();
    }
}
