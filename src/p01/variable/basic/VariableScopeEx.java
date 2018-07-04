package p01.variable.basic;

public class VariableScopeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 15;	// v1은 main method에서 선언된 변수
		
		if(v1 > 10)	
		{
			int v2 = v1 - 10;	// v2는 if 문에서 선언된 변수
		}
		
		{
			int w = 0;
		}
		
		// v2는 if문에서만 살아있기 때문에 v3 값계산시 사용할 수 없음
//		int v3 = v1 + v2 + 5;
//		int v4 = w +10;
	}

}
