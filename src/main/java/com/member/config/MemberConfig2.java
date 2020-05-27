package com.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.member.DataBaseConnectionInfo;

@Configuration  // 스프링 컨테이너 생성
public class MemberConfig2 {
	
	@Bean
	public DataBaseConnectionInfo DataBaseConnectionInfo() {
		DataBaseConnectionInfo info = new DataBaseConnectionInfo();
		info.setJdbcUrl("jdbc:mysql://127.0.0.1:3307/camelstudy?useSSL=false&amp;serverTimezone=Asia/Seoul");
		info.setUserId("root");
		info.setUserPw("root");
		return info;
	}
}
