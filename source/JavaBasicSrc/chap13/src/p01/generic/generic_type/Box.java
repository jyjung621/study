package p01.generic.generic_type;

//	Box 클래스를 만든 목적 : 모든 data type에서 사용할 수 있는
//					field, method를 만드는 것임
public class Box<T> {
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
}
