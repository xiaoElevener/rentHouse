package com.xiao.filter;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestFilter {
	
	@Before
	public void perpare(){
		ApplicationContext  context= new ClassPathXmlApplicationContext("spring-shiro.xml");
		
	}
}
