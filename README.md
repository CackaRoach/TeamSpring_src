# KAIKEI

<details>
<summary>Git 관리법</summary>
<div markdown="1">
<h3>master <-- Branch(Commit)</h3>

PPT참조

<h3>master --> Branch (Rebase) 하는법</h3>

Spring --> Window --> Show view --> other --> git Repositories 추가

git Repositories --> TeamSpring_src --> Branches --> Local --> (자신의 Branch ) --> Rebase
  --> Remote Tracking --> origin/master --> Rebase
</div>
</details>

<details>
<summary>SQL테이블 구조</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/54826450/67838268-41a95b80-fb34-11e9-84c8-2604f8c3e7ff.PNG">

SQL파일 Teamspring/구현에 있습니다.
</div>
</details>

<details>	
  <summary><del>10/29 변경사항</del></summary>
<div markdown="1">
  <h3>src -> main -> webapp -> WEB-INF -> spring -> root-context.xml userMapper밑에 추가</h3>
  
    <bean id="statementMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
       <property name="mapperInterface" value="com.ts.kaikei.dao.StatementDAO" />
       <property name="sqlSessionTemplate" ref="sqlSession" />
    </bean>
    
    <bean id="customerMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
       <property name="mapperInterface" value="com.ts.kaikei.dao.CustomerDAO" />
       <property name="sqlSessionTemplate" ref="sqlSession" />
    </bean>
    
    <bean id="accountMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
       <property name="mapperInterface" value="com.ts.kaikei.dao.AccountDAO" />
       <property name="sqlSessionTemplate" ref="sqlSession" />
    </bean>
    
    <bean id="companyMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
       <property name="mapperInterface" value="com.ts.kaikei.dao.CompanyDAO" />
       <property name="sqlSessionTemplate" ref="sqlSession" />
    </bean>

</div>
</details>

<details>
<summary>10/30 변경사항</summary>
<div markdown="1">
<h3>statement table 변경</h3>
date : varchar(8) --> date()
  
debetor : not null --> null
  
creditor : varchar --> integer
</div>
</details>

<details>
  <summary><del>10/31 변경사항</del></summary>
<div markdown="1">
  <h3>merge완료</h3>
  <h3>.gitignore 파일 추가</h3>
    target/

    root-context.xml
    pom.xml

</div>
</details>

<details>
<summary>11/01 변경사항</summary>
<div markdown="1">
<h3>company table 변경</h3>
state_cd --> auth_cd
</div>
</details>

<details>
<summary>!11/16 변경사항!</summary>
<div markdown="1">
<h3>1. 테마 자문받은 내용대로 수정하였습니다.</h3>
<h3>2. 세션 수정</h3>
  --> e.g) 회사코드 호출시
  --> String company_cd = httpSession.getAttribute("company_cd").toString(); 으로 부르시면 됩니다.
  현재 세션값
  	httpSession.setAttribute("id", getUserVO.getId()); // 로그인 user id
		httpSession.setAttribute("posit_cd", getUserVO.getPosit_cd()); // 직급 code
		httpSession.setAttribute("company_cd", getUserVO.getCompany_cd()); // 회사 code
<h3>3. 절대경로 /kaikei 제외</h3>
  --> Tomcat server.xml 마지막줄 변경
  --> <Context docBase="KAIKEI" path="" reloadable="true" source="org.eclipse.jst.jee.server:KAIKEI"/></Host>
</div>
</details>
