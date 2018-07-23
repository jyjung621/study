package p08.class_getclass;

public class ClassEx {
	public static void main(String[] args) {
		Car car = new Car();
		//	Object class의 getClass 메소드를 호출
		//	clazz1의 Car class의 runtime object의 Class type을 리턴함
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage());
		System.out.println();
		
		try {
			//	Class의 forName메소드를 이용하여 Class의 객체를 가져옴
			Class clazz2 = Class.forName("p08.class_getclass.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
