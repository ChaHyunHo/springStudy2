
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

#### Java 파일 분리 

	XML을 이용한 스프링 설정파일 제작을 Java 파일로 제작할 수 있는 방법에 대해 학습
	분리하는 방법은 개발자 마음이지만 대부분 기능별로 분리한다. 
	
	Member 패키지에 있는 MemberConfig.java에 설정들을 분리한다.(데이터관련, DB 정보관련 별로분리, 서비스관련)
	 MemberConfig1, MemberConfig2, MemberConfig3로 분리한다.
	 
```
MemberConfig1

@Configuration  // 스프링 컨테이너 생성
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

 MemberConfig2 
 
 @Configuration 
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
 
 

 MemberConfig3
 
 @Configuration  // 스프링 컨테이너 생성
public class MemberConfig3 {
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfo; //  MemberConfig2에서 이미 스프링 컨테이너에 빈으로 생성되있으므로 MemberConfig3에 주입하여 사용한다.
	
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

Mian Class 일부

	
		AnnotationConfigApplicationContext ctx = new
		AnnotationConfigApplicationContext(MemberConfig1.class, MemberConfig2.class,
		MemberConfig3.class); // 각각에 클래스를 콤마로 구분하여 입력하면 된다.
		
```

#### @Import 어노테이션 이용
		AnnotationConfigApplicationContext ctx = new
		AnnotationConfigApplicationContext(MemberConfig1.class, MemberConfig2.class,
		MemberConfig3.class); // 각각에 클래스를 콤마로 구분하여 입력하면 된다.
		위에서 했던 코드이다. 기능별로 분리한 설정파일을 각각 입력해주었는데 만약 
		설정파일이 많다면 전부다 입력해주어야 하는 불편함이 있다. 따라서 어느 한 설정파일 한곳으로
		임포트해주면 한개만 작성해도 된다.
ex)
```
@Configuration 
@Import({MemberConfig1.class, MemberConfig2.class, MemberConfig3.class}) // MemberConfig1에서 2와3만 써주고 AnnotationConfigApplicationContext(MemberConfig1.class)라고 입력해주어도 상관없음
public class MemberConfig {}

Main Class  일부

AnnotationConfigApplicationContext ctx =
		new AnnotationConfigApplicationContext(MemberConfig.class);
```

