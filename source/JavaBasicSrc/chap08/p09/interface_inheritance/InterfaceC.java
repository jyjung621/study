package p09.interface_inheritance;

public interface InterfaceC extends InterfaceA, InterfaceB {
	/*
	 * 	InterfaceC는 InterfaceA, InterfaceB를 상속
	 * 	InterfaceA의 methodA, InterfaceB의 methodB를 상속한 효과 가짐
	 */
	public void methodC();
}
