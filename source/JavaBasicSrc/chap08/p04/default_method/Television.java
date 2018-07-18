package p04.default_method;

//public abstract class Television implements RemoteControl {
public class Television implements RemoteControl {

	// 필드
	private int volume;

	// turnOn() 추상메소드의 실체메소드
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	// turnOff() 추상메소드의 실체메소드
	// 구현클래스인 Television에서 RemoteControl의 추상메소드를
	// 구현하지 않고, 추상메소드로 다시 선언 가능함
	// 추상메소드로 만들면, Television은 기본적으로 추상클래스로 변경되어야만 함
	// public abstract void turnOff();
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	// setVolume() 추상메소드의 실체메소드
	@Override
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
