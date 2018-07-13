package p03.multi_interface;

public interface RemoteControl {
	
	//	상수
	static final int MAX_VOLUME = 10;
	//	field 선언할 때 static final을 안붙이더라도
	//	자바 컴파일할 때 자동으로 static final을 붙임
	int MIN_VOLUME = 0;
	
	//	추상 메소드
	public abstract void turnOn();
	//	추상메소드 선언시 public abstract를 안붙이더라도
	//	자바가 컴파일할 때 자동으로 public abstract 붙임
	void turnOff();
	void setVolume(int volume);
	
	//	디폴트 메소드 (자바 8버전 이후 가능)
	//	public이 자동적으로 붙음
	default void setMute(boolean mute)
	{
		if(mute)
		{
			System.out.println("무음 처리합니다.");
		}
		else
		{
			System.out.println("무음 해제합니다.");
		}
	}
	
	//	정적메소드(자바 8버전 이후 가능)
	static void changeBattery()
	{
		System.out.println("건전지를 교환합니다.");
	}
}