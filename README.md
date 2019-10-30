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
<summary>SQL테이블 구조, SQL문</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/54826450/67838268-41a95b80-fb34-11e9-84c8-2604f8c3e7ff.PNG">
</div>
</details>

<details>
<summary>10/29 변경사항</summary>
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
