package p04.bounded_type;

public class Util {
	//	T extexds Number 의미
	//		- type T가 Number type의 자식만 허용한다는 의미
	public static <T extends Number> int compare(T t1, T t2)
	{
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
	}
}
