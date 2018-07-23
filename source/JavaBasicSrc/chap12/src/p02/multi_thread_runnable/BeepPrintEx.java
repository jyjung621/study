package p02.multi_thread_runnable;

public class BeepPrintEx {
	public static void main(String[] args) {
		//	main method가 처음 식작할 때, main-thread가 실행됨
		
		Runnable beepTask = new BeepTask();
		//	thread 생성하는 방법 Thread(Runnable data)
		Thread thread = new Thread(beepTask);
		// start() : thread를 시작하게 함 ==> beepTask.run 메소드 실행
		//	main thread와 다른 새로운 thread 실행
		thread.start();
		
		for(int i=0; i<5; i++)
		{
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
