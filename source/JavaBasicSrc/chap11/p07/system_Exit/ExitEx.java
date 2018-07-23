package p07.system_Exit;

public class ExitEx {
	public static void main(String[] args) {
		// 보안 관리자 설정
		//	parameter에 SecurityManager class의 익명객체를 넘김
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				//	status가 5가 아니면 SecurityException을 발생
				//	5이면 JVM 정상 종료하게 하는 로직
				if (status != 5) {
					throw new SecurityException();
				}
			}
		});

		for (int i = 0; i < 10; i++) {
			// i값 출력
			System.out.println(i);
			try {
				// JVM 종료 요청
				System.exit(i);
			} catch (SecurityException e) {
				System.out.println("SecurityException 발생 : " + i);
			}
		}
	}
}
