package com.member;

import com.member.dao.StudentDao;
import com.member.service.StudentAllSelectService;
import com.member.service.StudentDeleteService;
import com.member.service.StudentModifyService;
import com.member.service.StudentRegisterService;
import com.member.service.StudentSelectService;

public class StudentAssembler {

	private StudentDao studentDao;
	private StudentRegisterService registerService;
	private StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private StudentSelectService selectService;
	private StudentAllSelectService allSelectService;
	
	public StudentAssembler() {
		studentDao = new StudentDao();
		registerService = new StudentRegisterService(studentDao);
		modifyService = new StudentModifyService(studentDao);
		deleteService = new StudentDeleteService(studentDao);
		selectService = new StudentSelectService(studentDao);
		allSelectService = new StudentAllSelectService(studentDao);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public StudentRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(StudentRegisterService registerService) {
		this.registerService = registerService;
	}

	public StudentModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public StudentDeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public StudentSelectService getSelectService() {
		return selectService;
	}

	public void setSelectService(StudentSelectService selectService) {
		this.selectService = selectService;
	}

	public StudentAllSelectService getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	
}
