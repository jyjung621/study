package p13.singlecton;

/******************************************************************
 * 	singleton 용어의 의미
 * 		- new로 생성된 객체는 오직 한 개만 존재
 * 		- 다른class에서 singleton객체를 사용할 때, 모두 동일한 instance를 사용
 ******************************************************************/
public class SingletonEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/***************************************
		 * 	컴파일 Error
		 * 	singleton의 생성자가 private으로 되어 있어서,
		 * 	다른 class에서 new로  인스턴스를 생성할 수 없음
		 ***************************************/
		/*
		Singleton obj1 = new Singletion();
		Singleton obj2 = new Singletion();
		 */
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2)
		{
			System.out.println("같은 Singleton 객체 입니다.");
		}
		else
		{
			System.out.println("다른 Singleton 객체 입니다.");
		}	
	}

}
