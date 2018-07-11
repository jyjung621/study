package p09.method_overloading;

public class CalculatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator myCalcu = new Calculator();
		
		System.out.println("square --- before");
		// 정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
		System.out.println("square --- after");
		
		System.out.println("rectangle --- before");
		// 직사각형의 럽이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		System.out.println("rectangle --- before");
		
		// 결과 출력
		System.out.println("정사각형 넓이 = " + result1);
		System.out.println("직사각형 넓이 = " + result2);
	}

}
