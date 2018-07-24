package p02.functionalinterface_parameter;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFuncionalInterface fi;
		
		//	(int x) 대신에 데이터 타입을 제거한 (x)로 사용가능
		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);
		
		fi = (x) -> { System.out.println(x*5); };
		fi.method(2);
		
		//	(x)로, 인수가 한개만 있으면 x로 표현가능
		//	 -> 이후에, 싱행문이 한개만 있으면 {} 제거 가능
		fi = x -> System.out.println(x*5);
		fi.method(2);
		
	}
}
