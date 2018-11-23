package com.cg.service;

import java.util.List;

import com.cg.dao.IStudentDao;
import com.cg.dao.StudentDaoImpl;
import com.cg.entity.Student;

public class StudentServiceImpl implements IStudentService{

	IStudentDao studentDao;

	public List<Student> getStudentDetail() {
		studentDao = new StudentDaoImpl();
		return studentDao.getStudentDetail();
	}

	public int insertStudent(Student st) {
		studentDao = new StudentDaoImpl();
		return studentDao.insertStudent(st);
	}

	public boolean updateStudent(Student st) {
		studentDao = new StudentDaoImpl();
		return studentDao.updateStudent(st);
	}

	public int deleteStudent(Student st) {
		studentDao = new StudentDaoImpl();
		return studentDao.deleteStudent(st);
	}

	public Student getStudentById(int id) {
		studentDao = new StudentDaoImpl();
		//System.out.println();
		return studentDao.getStudentById(id);
	}

}
