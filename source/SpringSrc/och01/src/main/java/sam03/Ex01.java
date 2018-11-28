package sam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ex01 {

	public static void main(String[] args) {
//		ApplicationContext bf = new FileSystemXmlApplicationContext("beam01.xml");
		ApplicationContext bf = new FileSystemXmlApplicationContext("C:\\sping\\springSrc39\\och01\\src\\main\\java\\sam03\\bean01.xml");

//		ApplicationContext bf = new FileSystemXmlApplicationContext("beam01.xml");
//		MessageBean mb = bf.getBean("mb", MessageBean.class);
		MessageBean mb = (MessageBean)bf.getBean("mb");
		mb.sayHello("spring");
	}

}
