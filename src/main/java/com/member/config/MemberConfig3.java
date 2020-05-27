package com.member.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.member.DataBaseConnectionInfo;
import com.member.service.EMSInformationService;

@Configuration  // 스프링 컨테이너 생성
public class MemberConfig3 {
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfo;
	
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
		dbInfos.put("dev", dataBaseConnectionInfo);
		info.setDbInfos(dbInfos);
		
		return info;
	}

		
}
