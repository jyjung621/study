package p02.functionalinterface_nonparameter;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = new MyFunctionalInterface() {
			
			@Override
			public void method() {
				//	실행문 작성
				String str = "method call_0";
				System.out.println(str);
			}
		};
		fi.method();
		
		fi = () -> {
			String str = "method call_1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call_2"); };
		fi.method();
		
		fi = () -> System.out.println("method call_3");
		fi.method();
		
	}
}
