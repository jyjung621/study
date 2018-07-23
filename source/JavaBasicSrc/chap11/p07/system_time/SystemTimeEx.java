package p07.system_time;

public class SystemTimeEx {
	public static void main(String[] args) {
		//	System.nanoTime(); : 1초를 1억(10^9)으로 나눈 것
		//	계산방법은 1970년 1월1일 0시0분0초를 시작으로 계산
		long time1 = System.nanoTime();
		System.out.println("time1 = " + time1);

		int sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			sum += i;
		}

		long time2 = System.nanoTime();
		System.out.println("time2 = " + time2);

		System.out.println("1 ~ 1000000까지의 합 : " + sum);
		System.out.println("계산에 " + (time2 - time1) + "ns(나노초)가 소요되었습니다.");
	}
}
