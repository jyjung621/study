package p16.access_mod.pack2;

import p16.access_mod.pack1.B;

public class C {
	
	// Field
	
	/***********************************************
	 * 	A class는 default로 선언되어 있어서 다른 package에 있는
	 * 	C class가 field로 사용 불가능
	 ***********************************************/
	//A a;
	
	
	/***********************************************
	 * 	B class가 pulic으로 선언되어 있어서 다른 package에 있는
	 * 	C class에서 선언 가능
	 ***********************************************/
	B b;

}
