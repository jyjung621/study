package p02.functionalinterface_return;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface fi;

		fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi.method(2, 5));

		fi = (x, y) -> {
			return x + y;
		};
		System.out.println(fi.method(2, 5));

		//	실행문이 return만 있으면, return 이라는 단어 삭제 가능
		fi = (x, y) -> x + y;
		System.out.println(fi.method(2, 5));

		fi = (x, y) -> sum(x, y);
		System.out.println(fi.method(2, 5));
	}

	public static int sum(int x, int y) {
		return x + y;
	}
}
