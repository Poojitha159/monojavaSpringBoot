package com.techlabs.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDaoImpl implements StudentDao{

	EntityManager entityManager;
	
	
	public StudentDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public void save(Student student) {
		this.entityManager.persist(student);
		
	}
	public List<Student> getAllStudents(){
		TypedQuery<Student> query=entityManager.createQuery("select s from Student s",Student.class);
		List<Student> studentList=query.getResultList();
		
		return studentList;
	}


	@Override
	public Student getStudentById(int i) {
		// TODO Auto-generated method stub
		Student student=entityManager.find(Student.class,i);
		return student;
	}


	@Override
	public List<Student> getStudentByFirstName(String firstName) {


		TypedQuery<Student> query=entityManager.createQuery("select s from Student s where firstName=?1",Student.class);
		query.setParameter(1,firstName);
		return query.getResultList();
	}


	@Override
	public List<Student> getStudentsByFirstNameandLastName(String firstName, String lastName) {
		TypedQuery<Student> query=entityManager.createQuery("select s from Student s where firstName=?1 and lastName=?2",Student.class);
		query.setParameter(1,firstName);
		query.setParameter(2, lastName);
		return query.getResultList();
	}


	@Override
	@Transactional
	public void updateStudent(Student student) {
		Student student2=entityManager.find(Student.class,student.getId());
		if(student2!=null) {
			this.entityManager.merge(student);
		}
		else {
			System.out.println("Student id not existed");
		}
	}


	@Override
	@Transactional
	public void deleteStudent(int id) {
		Student student=entityManager.find(Student.class,id);
		if(student!=null) {
			this.entityManager.remove(student);
		}
		else {
			System.out.println("Student with id "+id+ " does not exists");
			}
	}


	@Override
	@Transactional
	public void updateStudentW(Student student) {
		Student student2=entityManager.find(Student.class,student.getId());
		if(student2!=null) {
			Query query = entityManager.createQuery("update Student s set s.firstName=?1 , s.lastName=?2,s.email=?3 where s.id=?4");
			query.setParameter(1, student.getFirstName());
			query.setParameter(2, student.getLastName());
			query.setParameter(3, student.getEmail());
			query.setParameter(4, student.getId());
			int res=query.executeUpdate();
			System.out.println(res);
		}
		else {
			System.out.println("Student id not existed");
		}
				
		
	}
	
	@Override
	@Transactional
	public void deleteAllStudents(int id) {
		
		Query query=entityManager.createQuery("delete from Student s where s.id<=?1");
		query.setParameter(1, id);
		int res=query.executeUpdate();
		System.out.println(res);
		
		
	}


	@Override
	@Transactional
	public void deleteStudentsLessthanThree(int id) {
		Query query=entityManager.createQuery("delete from Student s where s.id>?1");
		query.setParameter(1, id);
		int res=query.executeUpdate();
		System.out.println("No oof rows effected"+res);
		
	}


	}


