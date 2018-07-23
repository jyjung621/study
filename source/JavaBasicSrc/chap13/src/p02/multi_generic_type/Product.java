package p02.multi_generic_type;

//	generic data type : T, M
//	Product class는 product type과 product 모델명을 관리
public class Product<T, M> {
	private T kind;
	private M model;

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	public M getModel() {
		return model;
	}

	public void setModel(M model) {
		this.model = model;
	}

}
