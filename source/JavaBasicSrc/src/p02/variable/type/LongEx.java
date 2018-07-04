package p02.variable.type;

public class LongEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long var1 = 10;
		long var2 = 20L;	// 'L'의 의미가 20이 long type임을 말함
		
		/*  오른쪽 literal의 기본 데이터 타입이 int여서, 
		 *  literal값이 2^31이 넘어가면 에러가 남 
		 */
		//long var3 = 10000000000; // 불가능
		long var3 = 10000000000L;
	}

}
