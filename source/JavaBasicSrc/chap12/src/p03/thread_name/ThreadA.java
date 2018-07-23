package p03.thread_name;

public class ThreadA extends Thread {
	public ThreadA() {
		//	Thread의 이름을 "ThreadA"라고 설정
		setName("ThreadA");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			//	getName() : thread의 이름을 가져오는 메소드
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}
