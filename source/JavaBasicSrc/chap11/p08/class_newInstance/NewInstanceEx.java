package p08.class_newInstance;

public class NewInstanceEx {
		public static void main(String[] args) {
			String className = null;
			try {
				//	className에 들어갈 클래스이름을 지정하는 로직 프로그래밍
				className = "p08.class_newInstance.SendAction";
				Class clazz = Class.forName(className);
				//Class clazz = Class.forName("p08.class_newInstance.ReceveAction");
				
				Action action = (Action) clazz.newInstance();
				action.execute();
			//	ClassNotFoundException
			//	- forName에서 잘못된 class나 패키지를 쓰면 발생
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			//	InstantiationException
			//	- newInstance() 메소드를 호출할 경우 Instance를 만들수 없을때 발생
			} catch (InstantiationException e) {
				e.printStackTrace();
			// IllegalAccessException
			//	- newInstance() 호출할 때, 접근자(public, default, protected, private)
			//	때문에 객체 생성할 수 없음
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
}
