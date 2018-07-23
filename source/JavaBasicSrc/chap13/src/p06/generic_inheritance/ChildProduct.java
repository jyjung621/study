package p06.generic_inheritance;

//	Generic type으로 선언된 부모 class를 자식 class에서 새로운 
//	generic type을 추가할 수 있음ㄴ
public class ChildProduct<T, M, C> extends Product<T, M> {
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}

}
