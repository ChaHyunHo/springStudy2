package com.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.member.dao.StudentDao;
import com.member.service.StudentAllSelectService;
import com.member.service.StudentDeleteService;
import com.member.service.StudentModifyService;
import com.member.service.StudentRegisterService;
import com.member.service.StudentSelectService;

@Configuration  // 스프링 컨테이너 생성
@Import({MemberConfig2.class, MemberConfig3.class})
public class MemberConfig1 {
	
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
	

		
}
