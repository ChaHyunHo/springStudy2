package com.member.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.member.DataBaseConnectionInfo;
import com.member.dao.StudentDao;
import com.member.service.EMSInformationService;
import com.member.service.StudentAllSelectService;
import com.member.service.StudentDeleteService;
import com.member.service.StudentModifyService;
import com.member.service.StudentRegisterService;
import com.member.service.StudentSelectService;

@Configuration  // 스프링 컨테이너 생성
public class MemberConfig {
	
	// <bean id="studentDao" class="com.member.dao.studentDao" />
	// 이 코드는 위 XML코드와 동일하다.
	@Bean // Bean객체를 생성하는 어노테이션
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}

	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}

	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}

	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public DataBaseConnectionInfo DataBaseConnectionInfo() {
		DataBaseConnectionInfo info = new DataBaseConnectionInfo();
		info.setJdbcUrl("jdbc:mysql://127.0.0.1:3307/camelstudy?useSSL=false&amp;serverTimezone=Asia/Seoul");
		info.setUserId("root");
		info.setUserPw("root");
		return info;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		
		info.setInfo("Education Management System program was developed in 2015.");
		info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setSsYear(2015);
		info.setSsMonth(1);
		info.setSsDay(1);
		info.setEeYear(2015);
		info.setEeMonth(2);
		info.setEeDay(22);
		
		List<String> developers = new ArrayList<>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		info.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		info.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<>();
		dbInfos.put("dev", DataBaseConnectionInfo());
		info.setDbInfos(dbInfos);
		
		return info;
	}

		
}
