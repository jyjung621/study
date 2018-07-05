package p01.op_unary;

public class IncreaseDecreaseOperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-------------------");
		x++;	// x = x + 1 
		++x;	// x = x + 1 ... 증가 후, 연산
		System.out.println("x = " + x);
		
		System.out.println("-------------------");
		y--;	// y = y - 1;
		--y;	// y = y - 1;
		System.out.println("y = " + y);
		
		System.out.println("-------------------");
		z = x++;	// 1) z = x;  2) x = x + 1;  ... 연산 후, 증가
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		
		System.out.println("-------------------");
		z = ++x;	// 1) x = x + 1;  2) z = x;  ... 증가 후, 연산
		System.out.println("z = " + z);
		System.out.println("x = " + x);
	}

}
