package p01.single_thread;

import java.awt.Toolkit;

public class BeepPrintEx {
	public static void main(String[] args) {
			
		//	Toolkit : 특정작업을 하다가 사용자에게 beep음을 줘서 경고를 함
		//Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++)
		{
			//toolkit.beep();
			System.out.println("BEEP....");
			try {
				//	강제로 0.5초 동안 core를 내놓고 정지상태에 있게함
				Thread.sleep(500);
			} catch (Exception e) {}
		}
		
		for(int i=0; i<5; i++)
		{
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}