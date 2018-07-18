package p02.object_hashcode;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	/*
	 * 	Object는 모든 클래스의 부모 class : 
	 * 		프로그램 유지보수 최소화하기 위해 equals 입력 데이터 타입을 Object로 했음
	 */
	public boolean equals(Object obj) {
		//	현재는 obj가 Key class만 존재
		if(obj instanceof Key)
		{
			Key compareKey = (Key) obj;
			if(this.number == compareKey.number)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return number;
	}
}
