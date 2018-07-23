package p04.thread_priority;

public class PriorityEx {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Thread thread = new CalcThread("thread" + i);

			//	특정 thread의 priority를 MAX_PRIORITY로 주더라도 
			//	항상 먼저 실행되는 것은 아니지만, 먼저 실행하라고 요청하는 의미
			if (i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
