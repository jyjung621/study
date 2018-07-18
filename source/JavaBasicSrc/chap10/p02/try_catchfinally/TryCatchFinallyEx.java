package p02.try_catchfinally;

public class TryCatchFinallyEx {

	public static void main(String[] args) {
			
		
		//	Class.forName 메소드 : class이름을 통해 class객체를 생성할 때, 중간단계로 사용함
		//	new ClassName ==> instance생성
		try {
			//	Exception 발생할 코드들... try안에 넣을것 
			System.out.println("try 실행");
			//Class clazz = Class.forName("java.lang.String");	//	정상
			Class clazz = Class.forName("java.lang.String2");	//	에러
		} catch (ClassNotFoundException e) {
			//	Catch에서 에러 처리할 코드 삽입
			
			//e.printStackTrace();
			//	고객에게 안내메세지에 대한 내용을 여기서 코딩함
			System.out.println("클래스가 존재하지 않습니다.");
		}
		//	finally는 선택 option(사용해도 되고 안사용해도됨)
		//	finally는 정상적으로 싱행되든 에러가 발생되든 반드시 실행됨
		//	에러나서 프로그램이 종료되더라도, 마지막으로 처리작업 진행함
		finally {
			System.out.println("finally 실행");
			
		}
	}

}
