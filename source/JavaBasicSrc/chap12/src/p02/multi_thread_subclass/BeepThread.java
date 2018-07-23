package p02.multi_thread_subclass;

import java.awt.Toolkit;

//	Thread의 자식 클래스 생성
public class BeepThread extends Thread {
	//	부모 Thread의 메소드인 run()을 Override
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++)
		{
			toolkit.beep();
			System.out.println("BEEP....");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}	
	
	}
}
