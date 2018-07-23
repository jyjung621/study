package p03.thread_name;

public class ThreadNameEx {
	public static void main(String[] args) {
		/*
		 * 	1. main thread
		 * 		- currentThread :  현재의 thread를 가져오는 메소드
		 */
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : " +mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름 : " + threadA.getName());
		threadA.start();

		ThreadB threadB = new ThreadB();
		System.out.println("작업 스레드 이름 : " + threadB.getName());
		threadB.start();
	}
}
