package p02.op_binary;

public class OverflowEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 1000000;
		int y = 1000000;
		int z = x * y;	// z값이 overflow 발생했음 (처리범위 초과함)
		
		System.out.println(z);
		
		long z1 = (long)x * y;
		System.out.println(z1);
	}

}
