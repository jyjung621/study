package p00.example07.ex01_1;

public class InterfaceTest1 {
	public static void main(String[] args) {
		
		Interface1Impl in1Impl = new Interface1Impl();
		
		
		System.out.println("in1Impl.interVar = " + in1Impl.interVar);
		System.out.println("Interface1.interVar = " + Interface1.interVar);
		in1Impl.interface1Method();
	}
}
