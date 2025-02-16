package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.techlabs.app.dto.CourseDTO;
import com.techlabs.app.dto.StudentDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;
import com.techlabs.app.repository.CourseRepository;
import com.techlabs.app.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	private StudentRepository studentRepository;
	private CourseRepository courseRepository;

	public StudentCourseServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public StudentDTO saveStudent(StudentDTO student) {
		//return studentRepository.save(student);
		Student student1=convertToEntity(student);
		return convertToDTO(studentRepository.save(student1));
		
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		return studentRepository.findAll().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<StudentDTO> getStudentById(int id) {
		return studentRepository.findById(id).map(this::convertToDTO);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);

	}

	@Override
	public CourseDTO saveCourse(CourseDTO course) {
		Course c=convertToEntity(course);
		return convertToDTO(courseRepository.save(c));
		//return courseRepository.save(course);
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		return courseRepository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<CourseDTO> getCourseById(int id) {
		return courseRepository.findById(id).map(this::convertToDTO);
	}

	@Override
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}

	/*
	 * @Override
	 * 
	 * @Transactional
	 * 
	 * public StudentDTO addStudentToCourse(int studentId, int courseId) {
	 * 
	 * Optional<Student> student = getStudentById(studentId); CourseDTO course =
	 * courseRepository.findById(courseId).orElseThrow(() -> new
	 * RuntimeException("Course not found")); student.getCourse().add(course);
	 * return studentRepository.save(student); }
	 */

	@Transactional
	@Override
	public StudentDTO addStudentToCourse(int studentId, int courseId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if (studentOptional.isPresent() && courseOptional.isPresent()) {
			Student student = studentOptional.get();
			Course course = courseOptional.get();
			student.getCourses().add(course);
			return convertToDTO(studentRepository.save(student));
		}
		return null;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public StudentDTO removeStudentFromCourse(int studentId, int
	 * courseId) { Optional<Student> student = getStudentById(studentId);
	 * Optional<Course> course = courseRepository.findById(courseId).orElseThrow(()
	 * -> new RuntimeException("Course not found"));
	 * student.getCourse().remove(course); return studentRepository.save(student); }
	 */

	@Transactional
	@Override
	public StudentDTO removeStudentFromCourse(int studentId, int courseId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if (studentOptional.isPresent() && courseOptional.isPresent()) {
			Student student = studentOptional.get();
			Course course = courseOptional.get();
			student.getCourses().remove(course);
			return convertToDTO(studentRepository.save(student));
		}
		return null;
	}

	private StudentDTO convertToDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setCourse(student.getCourses().stream().map(this::convertToDTO).collect(Collectors.toSet()));
		return studentDTO;
	}

	private Student convertToEntity(StudentDTO studentDTO) {
		Student student = new Student();
		student.setId(studentDTO.getId());
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setCourses(studentDTO.getCourse().stream().map(this::convertToEntity).collect(Collectors.toSet()));
		if(studentDTO.getCourse()!=null) {
			student.setCourses(studentDTO.getCourse().stream().map(this::convertToEntity).collect(Collectors.toSet()));
		}
		return student;
	}

	private CourseDTO convertToDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setTitle(course.getTitle());
		return courseDTO;
	}

	private Course convertToEntity(CourseDTO courseDTO) {
		Course course = new Course();
		course.setId(courseDTO.getId());
		course.setTitle(courseDTO.getTitle());
		return course;
	}

}
