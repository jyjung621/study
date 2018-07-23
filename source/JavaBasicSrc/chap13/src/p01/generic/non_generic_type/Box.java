package p01.generic.non_generic_type;

//	Box 클래스를 만든 목적 : 모든 data type에서 사용할 수 있는
//					field, method를 만드는 것임
public class Box {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
