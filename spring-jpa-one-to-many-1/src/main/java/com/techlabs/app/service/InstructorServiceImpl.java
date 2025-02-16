package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Instructor;
import com.techlabs.app.repository.CourseRepository;
import com.techlabs.app.repository.InstructorRepository;

import jakarta.transaction.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService{

	private InstructorRepository 	instructorRepository;
	private CourseRepository 	courseRepository;
	
	public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
		super();
		this.instructorRepository = instructorRepository;
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Instructor> findAllInstructors() {
		
		return instructorRepository.findAll();
	}
	@Override
	public Instructor saveInstructor(Instructor instructor) {

	return instructorRepository.save(instructor);
	}
	
	@Override
	public Instructor getInstructorByid(int id) {
				return instructorRepository.findById(id).orElse(null);
	}
	@Override
	public void deleteById(Instructor instructor) {
		instructorRepository.delete(instructor);
	}
	
	@Override
	@Transactional
    public boolean removeCourseFromInstructor(int instructorId, int courseId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalInstructor.isPresent() && optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            if (course.getInstructor() != null && course.getInstructor().getId() == instructorId) {
                course.setInstructor(null);
                courseRepository.save(course);
                return true;
            }
        }
        return false;
    }
	
	@Override
	public Instructor addCoursetoInstructor(int id, int courseId) {

		Instructor instructor = instructorRepository.findById(id).orElse(null);
		if(instructor!=null) {
			Course course=courseRepository.findById(courseId).orElse(null);
			if(course!=null) {
				if(course.getInstructor()==null) {
					instructor.addCourse(course);
					course.setInstructor(instructor);
					instructorRepository.save(instructor);
				}
				else {
					System.out.println("Instructor is already assigned with course");
				}
			}
			
		}
		
		return null;
	}
}
