package p02.variable.type;

public class GarbageValueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte var1 = 125;	// var1 : byte타입(1byte)에 125값을 assign(할당)
		int  var2 = 125;	// var2 : int 타입(4byte)에 125값을 assign
		
		for(int i=0; i<5; i++)
		{
			var1++;
			var2++;
			System.out.println("var1 = " + var1 + "\t" + "var2 = " + var2);
		}
	}

}
