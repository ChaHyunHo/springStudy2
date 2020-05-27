package com.member.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  // 스프링 컨테이너 생성
@Import({MemberConfig1.class, MemberConfig2.class, MemberConfig3.class})
public class MemberConfig {}
