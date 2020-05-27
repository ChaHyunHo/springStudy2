
# 어노테이션을 이용한 스프링 설정

	기본에 XML을 이용한 스프링 설정파일 제작을  JAVA파일로 제작할 수 있는 방법에 대해서 학습

#### XML파일을 JAVA파일로 변경하기
	기존 어플리케이션을 만들때 XML로 container을 생성하여 스프링을 설정하였다.
	이번에는 XML이 아닌 JAVA를 이용하여 설정한다.
	
	설정 파일은 해당 패키지 내에 설정하는 것으로 정했다.
	```
	@Configuration  // 스프링 컨테이너 생성
	public class MemberConfig {
	
	// <bean id="studentDao" class="com.member.dao.studentDao" /> XML 빈설정 코드
	// 이 메소드는 위 XML코드와 같다고 생각하면된다.
		public StudentDao studentDao() {
			return new StudentDao();
		}
		
	}
	```
	
여러가지 빈설정에 대해 자바로 작성하는 경우이다.
```
<bean id="informationService" class="ems.member.service.EMSInformationService">
	<property name="info">
		<value>Education Management System program was developed in 2015.</value>
	</property>
	<property name="copyRight">
		<value>COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.</value>
	</property>
	<property name="ver">
		<value>The version is 1.0</value>
	</property>
	<property name="sYear">
		<value>2015</value>
	</property>
	<property name="sMonth">
		<value>1</value>
	</property>
	<property name="sDay">
		<value>1</value>
	</property>
	<property name="eYear" value="2015" />
	<property name="eMonth" value="2" />
	<property name="eDay" value="28" />
	<property name="developers">
		<list>
			<value>Cheney.</value>
			<value>Eloy.</value>
			<value>Jasper.</value>
			<value>Dillon.</value>
			<value>Kian.</value>
		</list>
	</property>
	<property name="administrators">
		<map>
			<entry>
				<key>
					<value>Cheney</value>
				</key>
				<value>cheney@springPjt.org</value>
			</entry>
			<entry>
				<key>
					<value>Jasper</value>
				</key>
				<value>jasper@springPjt.org</value>
			</entry>
		</map>
	</property>
	<property name="dbInfos">
		<map>
			<entry>
				<key>
					<value>dev</value>
				</key>
				<ref bean="dataBaseConnectionInfoDev"/>
			</entry>
			<entry>
				<key>
					<value>real</value>
				</key>
				<ref bean="dataBaseConnectionInfoReal"/>
			</entry>
		</map>
	</property>
</bean>
```

Java config (List type , Map type) 
코드의 핵심부분만 작성

프로퍼티가 리스트 or 맵인경우 빈(Bean)값 초기화 방법
	
```
<bean id="informationService" class="ems.member.service.EMSInformationService">
		<property name="developers">
		<list>
			<value>Cheney.</value>
			<value>Eloy.</value>
			<value>Jasper.</value>
			<value>Dillon.</value>
			<value>Kian.</value>
		</list>
	</property>
	<property name="administrators">
		<map>
			<entry>
				<key>
					<value>Cheney</value>
				</key>
				<value>cheney@springPjt.org</value>
			</entry>
			<entry>
				<key>
					<value>Jasper</value>
				</key>
				<value>jasper@springPjt.org</value>
			</entry> 
		</map>
	</property>
</bean>

.....
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		
		// 리스트 작성
		List<String> developers = new ArrayList<String>(); 
			developers.add("Cheney.");
			developers.add("Eloy.");
			developers.add("Jasper.");
			developers.add("Dillon.");
			developers.add("Kian.");
			
			info.setDevelopers(developers);
		
		// 맵 작성
		Map<String, String> administrators = new HashMap<String,String>();
			administrators.put("Cheney", "cheney@springPjt.org");
			administrators.put("Jasper", "jasper@springPjt.org");
			
			info.setAdministrators(administrators);
	}
	
	Main class)
		/*
		 * GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
		 * "file:src/main/webapp/WEB-INF/spring/context-**.xml");
		 */
		
		AnnotationConfigApplicationContext ctx =
					new AnnotationConfigApplicationContext(MemberConfig.class); // 해당 설정파일의 클래스를 불러와 적용한다.
	
```
