package com.cg.service;

import java.util.List;

import com.cg.entity.Student;

public interface IStudentService {

	 int insertStudent(Student st);
	 boolean updateStudent(Student st);
	 int deleteStudent(Student st);
	 List<Student> getStudentDetail();
	 Student getStudentById(int id);

}
