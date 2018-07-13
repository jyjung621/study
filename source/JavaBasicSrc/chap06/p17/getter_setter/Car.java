package p17.getter_setter;

public class Car {

	private int speed;
	private boolean stop;

	// get이나 is로 시작하는 메소드 => getter(field값을 가져올 때 사용)
	public int getSpeed() {
		// 사용자가 이 메소드를 잘못 사용하는 것을 방지하는 기능
		if (speed < 0) {
			this.speed = 0;
			return speed;
		} else {
			return speed;
		}
	}

	// set으로 시작하는 메소드 => setter(field값을 설정할 때 사용)
	public void setSpeed(int speed) {
		this.speed = speed;
		if (stop) {
			this.speed = 0;
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
