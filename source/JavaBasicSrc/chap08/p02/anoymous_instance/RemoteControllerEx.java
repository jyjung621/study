package p02.anoymous_instance;

public class RemoteControllerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/******************************************************
		 * 	Interface 구현방법
		 * 	2. 별도의 구현 클래스 만들지 않고, RemoteControl 인터페이스 타입에
		 * 		익명(구현클래스 이름x) 구현객체를 생성하여 사용하는 방법	
		 * 
		 * 	**익명구현객체**
		 * 	  - 구현클래스를 생성할 필요는 없고, 단지 일회성으로 사용할 경우에 사용함
		 ******************************************************/
		RemoteControl rc = new RemoteControl() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("anonymous-turnon");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("anonymous-turnoff");
			}

			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				System.out.println("anonymous-setvolume " + volume);
			}

		};
		
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
		
		/******************************************************
		 * 	Interface 구현방법
		 * 	1. Interface의 구현 클래스(Audio)를 만들어서
		 *		 부모의 Interface인 RemoteControl에 할당하여 사용하는 방법
		 ******************************************************/		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
	}

}
