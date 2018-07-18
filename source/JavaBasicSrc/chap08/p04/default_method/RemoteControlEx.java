package p04.default_method;

public class RemoteControlEx {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		//	RemoteControl Interface의 default method 호출
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		//	RemoteControl Interface의 default method를
		//	Audio에서 Override한 것을 호출 ==> polymorphism
		rc.setMute(true);
	
		//	RemoteControl의 정적 메소드 호출(객체(인스턴스) 생성없이 바로 호출가능)
		RemoteControl.changeBattery();
	}

}