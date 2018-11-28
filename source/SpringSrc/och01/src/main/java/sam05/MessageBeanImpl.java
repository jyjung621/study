package sam05;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greet;
	
	
	public MessageBeanImpl() {}


	public MessageBeanImpl(String name, String greet) {
		this.name = name;
		this.greet = greet;
	}


	@Override
	public void sayHello() {
		System.out.println(name+"님!! " + greet);

	}

}
