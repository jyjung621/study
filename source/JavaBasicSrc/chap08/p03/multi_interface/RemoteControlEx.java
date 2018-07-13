package p03.multi_interface;

public class RemoteControlEx {

	public static void main(String[] args) {
		RemoteControl rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		//	StamrTelevision을 부모인 RemoteControl interface에 할당
		rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		//rc.search("http://www.naver.com");
		
		//	StamrTelevision을 부모인 Searchable interface에 할당
		Searchable search = new SmartTelevision();
		search.search("http://www.naver.com");
		//search.turnOn();
		//search.turnOff();
	}

}