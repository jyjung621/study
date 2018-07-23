package p02.multi_thread_runnable;

import java.awt.Toolkit;

public class BeepTask implements Runnable {

	//	Runnable의 추상메소드인 run을 override
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
