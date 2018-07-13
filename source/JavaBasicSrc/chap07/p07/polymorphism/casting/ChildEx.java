package p07.polymorphism.casting;

public class ChildEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 부모인 Parent class에 자식인 Child 객체를 할당(assign)
		Parent parent = new Child();
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/*
		parent.field2 = "data2";
		parent.method3();
		*/
		
		// 부모변수를 다시 자식으로 강제 형변환(casting)
		Child child = (Child) parent;
		child.field2 = "yyy";
		child.method3();
		
		

	}

}
