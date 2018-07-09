package p02.array;

public class ArrayCopyByForEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// old : 배열 길이가 3
		int[] oldIntArray = {1,2,3};
		// new : 배열 길이가 5 ... new로 새로운 객체로 만들면서 0로 초기화
		int[] newIntArray = new int[5];
		
		// oldStrArray의 3개 원소값을 newStrArray에 복사
		for(int i=0; i<oldIntArray.length; i++)
		{
			newIntArray[i] = oldIntArray[i];
		}
		
		for(int i=0; i<newIntArray.length; i++)
		{
			System.out.print(newIntArray[i] + ", ");
		}
	}

}
