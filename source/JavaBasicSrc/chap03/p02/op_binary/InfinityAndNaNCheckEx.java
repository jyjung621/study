package p02.op_binary;

public class InfinityAndNaNCheckEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 5;
		double y = 0.0;
		
		//double z = x / y;		// 5/0 ==> 무한대(Infinity)
		double z = x % y;		// 5%0 ==> NaN(Not a Number)
		
		System.out.println(Double.isInfinite(z));
		// Infinity(무한대)도 숫자임
		System.out.println(Double.isNaN(z));
		// Infinity + 2 => Infinity,  NaN + 2 => NaN
		System.out.println(z+2);
	}

}
