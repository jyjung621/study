package p01.inheritance_basic;

//	extends + 부모클래스이름 ==> 자식클래스를 만드는 방법
public class DmbCellPhone extends CellPhone {

	// field : 자식클래스
	int channel;

	// 생성자
	public DmbCellPhone(String model, String color, int channel) {
		
		//	super() : 자바 시스템에서 super()를 자동적으로 넣어줌
		super();
		this.model = model;
		this.color = color;
		this.channel = channel;

	}

	// method
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}

	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번 으로 바꿉니다.");
	}

	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}

}
