package p00.example.ex04;

public class Pair<T, M> {
	private T key;
	private M value;
	
	public Pair(T key, M value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public M getValue() {
		return value;
	}


}
