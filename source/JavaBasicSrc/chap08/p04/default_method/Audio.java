package p04.default_method;

public class Audio implements RemoteControl {
	// 필드
	private int volume;
	private boolean mute;

	// turnOn() 추상메소드의 실체메소드
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	// turnOff() 추상메소드의 실체메소드
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

	// setVolume() 추상메소드의 실체메소드
	@ Override
	
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + volume);
	}
	
	@Override
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		this.mute = mute;
		if(mute)
		{
			System.out.println("Audio 무음 처리 합니다.");
		}
		else
			System.out.println("Audio 무음 해제 합니다.");
	}

}