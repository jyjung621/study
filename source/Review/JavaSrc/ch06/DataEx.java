package ch06;

class Data {
	int kor;
	int eng;
	int math;

	// Call by Reference
	void add(Data d1, Data d2) {
		d1.kor = d2.eng;
		System.out.println("Method 국어 점수 : " + d1.kor);
	}
	// Call by Value
	void add2(int kor, int eng) {
		kor = eng;
		System.out.println("Method 국어 점수 : " + kor);
	}
}

public class DataEx {
	public static void main(String[] args) {
		Data d1 = new Data();
		Data d2 = new Data();
		Data d3 = new Data();

		d1.kor = 50;
		d1.math = 70;
		d2.eng = 80;
		d3.add(d1, d2);
		d3.add2(d1.kor, 90);
		System.out.println("Main 국어 점수 : " + d1.kor);
	}
}
