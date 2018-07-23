package p04.thread_priority;

public class CalcThread extends Thread {
	//	Constructor
	public CalcThread(String name) {
		setName(name);
	}
	
	//	Thread의 run method를 override
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
		}
		System.out.println(getName());
	}
}
