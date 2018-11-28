package com.oracle.DI05;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//	bean -> student1
		CollectionBean collectionBean = ctx.getBean("collectionBean", CollectionBean.class);
		Map<String, String> addressList = (Map<String, String>)collectionBean.getAddressList();
		System.out.println("고길동 주소 : " + addressList.get("고길동"));
		System.out.println("중앙 주소 : " + addressList.get("중앙"));

		ctx.close();
	}

}
