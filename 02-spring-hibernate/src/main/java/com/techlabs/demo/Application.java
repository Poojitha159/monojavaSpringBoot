package com.techlabs.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techlabs.demo.dao.StudentDao;
import com.techlabs.demo.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private StudentDao studentDao;
	

	public Application(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloWorld");
		//addStudent();
		//getAllStudents();
		//getStudentById();
		//getStudentByFIrstName();
		//getStudentsByFirstNameandLastName();
		//updateStudentW();
		//updateStudent();
		//deleteStudent();
		//deleteAllStudents();
		deleteStudentsLessthanThree();
			
	}

	private void deleteStudentsLessthanThree() {
		studentDao.deleteStudentsLessthanThree(12);
		
	}

	private void deleteAllStudents() {
		studentDao.deleteAllStudents(14);
		
	}

	
	private void updateStudentW() {
		Student student=new Student(3,"karthikP","pasala","karthik@gmail.com");
		studentDao.updateStudentW(student);

		
	}

	private void deleteStudent() {
		studentDao.deleteStudent(13);
		
	}

	private void updateStudent() {
		Student student=new Student(1,"Poojitha","Harshini","poojitha@gmail.com");
		studentDao.updateStudent(student);
		
	}

	private void getStudentsByFirstNameandLastName() {
		List<Student> students=studentDao.getStudentsByFirstNameandLastName("karthik","pasala");
		for(Student s:students) {
			System.out.println(s);
		}
		
	}

	private void getStudentByFIrstName() {
		

		List<Student>students=studentDao.getStudentByFirstName("Poojitha");
		for(Student s:students) {
			System.out.println(s);
		}
	}

	private void getStudentById() {
		

		Student student=studentDao.getStudentById(3);
		if(student!=null) {
		System.out.println(student);
		}
		else {
			System.out.println("Student not found");
		}
		
	}

	private void getAllStudents() {

	List<Student> studentList=studentDao.getAllStudents();
	for(Student s:studentList) {
		System.out.println(s);
	}
	}

	private void addStudent() {
		Student student=new Student("siri","narayan","siri@gmail.com");
		studentDao.save(student);
	}

}
