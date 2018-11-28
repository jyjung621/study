package com.oracle.env03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Main 1 start");
		//	환경 파일이 가장먼저 실행됨
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("Main 2");
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		System.out.println("Main 3");
		
		System.out.println("connection.getAdminId  adminID : " + connection.getAdminId());
		System.out.println("connection.getAdminPw  adminPW : " + connection.getAdminPw());
		System.out.println("connection.getSub_adminId  sub_adminID : " + connection.getSub_adminId());
		System.out.println("connection.getSub_adminPw  sub_adminPW : " + connection.getSub_adminPw());

		System.out.println("Main 4");
		ctx.close();
		System.out.println("Main 5 end");
	}

}



//	Main 1 start
//	11월 13, 2018 9:50:51 오전 org.springframework.context.support.AbstractApplicationContext prepareRefresh
//	정보: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@439f5b3d: startup date [Tue Nov 13 09:50:51 KST 2018]; root of context hierarchy
//	Properties Run
//	11월 13, 2018 9:50:52 오전 org.springframework.core.io.support.PropertiesLoaderSupport loadProperties
//	정보: Loading properties file from class path resource [admin3.properties]
//	11월 13, 2018 9:50:52 오전 org.springframework.core.io.support.PropertiesLoaderSupport loadProperties
//	정보: Loading properties file from class path resource [sub_admin3.properties]
//	11월 13, 2018 9:50:52 오전 org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
//	정보: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2f7c7260: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,applicationConfig,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor,adminConfig,Properties]; root of factory hierarchy
//	adminConfig Run
//	setter!!
//	afterProperiesSet()
//	Main 2
//	Main 3
//	connection.getAdminId  adminID : admin
//	connection.getAdminPw  adminPW : 12345
//	connection.getSub_adminId  sub_adminID : sub2
//	connection.getSub_adminPw  sub_adminPW : 67890
//	Main 4
//	11월 13, 2018 9:50:52 오전 org.springframework.context.support.AbstractApplicationContext doClose
//	정보: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@439f5b3d: startup date [Tue Nov 13 09:50:51 KST 2018]; root of context hierarchy
//	11월 13, 2018 9:50:52 오전 org.springframework.beans.factory.support.DefaultSingletonBeanRegistry destroySingletons
//	정보: Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2f7c7260: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,applicationConfig,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor,adminConfig,Properties]; root of factory hierarchy
//	destroy()
//	Main 5 end
