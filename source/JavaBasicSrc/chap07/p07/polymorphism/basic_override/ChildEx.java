package p07.polymorphism.basic_override;

public class ChildEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child child = new Child();
		
		/*********************************
		 * 	자식 인스턴스를 부모 클래스로 형변환 시켰음
		 * 	parent는 부모 클래스의 메소드만 사용가능
		 *********************************/
		Parent parent = child;
		parent.method1();
		/******************************************************			
		 * 	부모의 method를 실행하더라도, 자식에서 해당 메소드를 override 했다면,
		 * 	자식의 override된 메소드를 호출함
		 ******************************************************/	
		parent.method2();
		//	자식 method를 부모 변수에서 호출 불가
		//parent.method3();
		
		SecondChild child2 = new SecondChild();
		parent = child2;
		parent.method1();
		parent.method2();
	}

}
