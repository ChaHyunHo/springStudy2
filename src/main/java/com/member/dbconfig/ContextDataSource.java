package com.member.dbconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 데이터베이스 설정
 * @author chamy
 *
 */
@Configuration
@EnableTransactionManagement
public class ContextDataSource {
	
	/**
	 *  datasource 설정
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3307/camelstudy?useSSL=false&amp;serverTimezone=Asia/Seoul");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}
	
	/**
	 * 트랜잭션 매니저 등록
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
