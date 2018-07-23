package p06.generic_inheritance;

//	StorageImpl class는 generic으로 선언된 인터페이스인 Storage를
//	implement한 class를 만들면서 generic으로 선언할 수 있음
public class StorageImpl<T> implements Storage<T> {
	private T[] array;

	public StorageImpl(int capacity) {
		this.array = (T[]) (new Object[capacity]);
	}

	@Override
	public void add(T item, int index) {
		array[index] = item;

	}

	@Override
	public T get(int index) {
		return array[index];
	}
}
