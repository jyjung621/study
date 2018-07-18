package p04.object_clone_deep;

import java.util.Arrays;

public class Member implements Cloneable {
	public String name;
	public int age;
	public int[] scores;
	public Car car;

	public Member(String name, int age,int [] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}

	@Override
	//	clone() 메소드 재정의
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("Member class의 clone 메소드");
		//	먼저 얕은 복제를 해서 name, age를 복제
		//	super ==> Object class
		Member cloned = (Member) super.clone();
		//	scores를 깊은 복제
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		//	car를 깊은 복제
		cloned.car = new Car(this.car.model);
		
		//	깊은 복제된 Member객체를 리턴
		return cloned;
	}
	
	public Member getMember() {
		Member cloned = null;
		try {
			//	clone 메소드가 Member class에서
			//	Object의 clone 메소드를 override한 것을 호출
			cloned = (Member) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return cloned;
	}
}
