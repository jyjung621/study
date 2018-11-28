package com.oracle.env01;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			//	.addLast() : 마지막에 우리가 설정한 환경파일이 추가됨
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			
			System.out.println("env -> " + env.getProperty("admin.id"));
			System.out.println("env -> " + env.getProperty("admin.pw"));
		} catch (IOException e) {
			
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX01.xml");
		System.out.println("load After");
		gCtx.refresh();
		System.out.println("refresh After");
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
