package com.member.service;

import java.util.Map;

import com.member.Student;
import com.member.dao.StudentDao;

public class StudentAllSelectService {

	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
	
}