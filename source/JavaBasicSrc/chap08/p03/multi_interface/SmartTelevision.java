package p03.multi_interface;

/*
 * 	class는 부모클래스가 1개만 가능하지만, 
 * 	Interface 구현클래스의 부모인 Interface의 숫자는 여러개 가능
 */
public class SmartTelevision implements RemoteControl, Searchable {
	
	private int volume;

	@Override
	
	//	Searchable Interface의 추상메소드
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	//	RemoteControl Interface의 추상메소드
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Smart TV를 켭니다.");
	}

	@Override
	//	RemoteControl Interface의 추상메소드
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Smart TV를 끕니다.");
	}

	@Override
	//	RemoteControl Interface의 추상메소드
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨: " + volume);
	}

}
