package p02.multi_thread_subclass;

public class BeepPrintEx {
	public static void main(String[] args) {
		//	부모 Thread type으로 자동 형변환
		Thread thread = new BeepThread();
		//	override한 자식 BeepThread의 run 메소드 실행
		thread.start();
		
		for(int i=0; i<5; i++)
		{
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}
