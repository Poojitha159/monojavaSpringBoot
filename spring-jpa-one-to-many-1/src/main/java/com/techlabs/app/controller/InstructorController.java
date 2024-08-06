package com.techlabs.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Instructor;
import com.techlabs.app.service.InstructorService;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
	private InstructorService instructorService;

	public InstructorController(InstructorService instructorService) {
		super();
		this.instructorService = instructorService;
	}

	@GetMapping()
	public List<Instructor> getAllInstructors(){
		return instructorService.findAllInstructors();
		
	}
	
	@PostMapping
	public Instructor addNewInstructor(@RequestBody Instructor instructor) {
		
		return instructorService.saveInstructor(instructor);
	}
	
	
	@PutMapping("/update")
	public Instructor updateInstructor(@RequestBody Instructor instructor) {
		Instructor uInstructor=instructorService.getInstructorByid(instructor.getId());
		if(uInstructor!=null) {
			return instructorService.saveInstructor(instructor);
		}
		return null;
	}
	
	
	@DeleteMapping("/remove/{id}")
	public void deleteInstructor(@PathVariable int id) {
		//instructorService.deleteById(id);
		Instructor instructor = instructorService.getInstructorByid(id);
		if(instructor!=null) {
		List<Course> courses=instructor.getCourse();
		for(Course course:courses) {
			course.setInstructor(instructor);
		}
		instructorService.deleteById(instructor);
		}
		
	}
	@PutMapping("{instId}/course/{courseId}")
	public ResponseEntity<HttpStatus> addCoursetoInstructor(@PathVariable(name="instId")int id,@PathVariable(name="courseid")int courseId){
		Instructor instrucor=instructorService.addCoursetoInstructor(id,courseId);
		return new  ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<Void> removeCourseFromInstructor(@PathVariable int instructorId, @PathVariable int courseId) {
        if (instructorService.removeCourseFromInstructor(instructorId, courseId)) {
           
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
