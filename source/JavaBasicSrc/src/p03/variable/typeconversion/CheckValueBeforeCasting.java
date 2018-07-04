package p03.variable.typeconversion;

public class CheckValueBeforeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 128;
		//int i = 127;
		
		if((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) 
		{
			System.out.println("byte type으로 변환할 수 없습니다.");
			System.out.println("다시 값을 확인해 주세요.");
		}
		else
		{
			byte b = (byte) i;	// int i를 byte로 강제 형변환
			System.out.println(b);
		}
	}		

}
