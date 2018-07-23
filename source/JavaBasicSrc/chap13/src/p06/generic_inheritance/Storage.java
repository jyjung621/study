package p06.generic_inheritance;

public interface Storage<T> {
	//	abstract method
	public void add(T item, int index);
	public T get(int index);
}
