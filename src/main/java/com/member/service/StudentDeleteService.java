package com.member.service;

import com.member.Student;
import com.member.dao.StudentDao;

public class StudentDeleteService {

	private StudentDao studentDao;
	
	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void delete(Student student) {
		if(verify(student.getsNum())) {
			studentDao.delete(student.getsNum());
		} else {
			System.out.println("Student information is available.");
		}
	}
	
	public boolean verify(String sNum){
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}
