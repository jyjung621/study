package p02.array;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ArrayCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// old : 배열 길이가 3
		String[] oldStrArray = {"java","array","copy"};
		// new : 배열 길이가 5 ... new로 새로운 객체로 만들면서 null로 초기화
		String[] newStrArray = new String[5];
		
		/**********************************************************
		 *  System.arraycopy(src, srcPos, dest, destPos, length);
		 *  	src 	: 원본 배열
		 *  	srcPos 	: 원본배열에서 복사할 항목의 시작인덱스
		 *  	dest 	: 새 배열
		 *  	destPos	: 새 배열에서 붙여넣을 시작 인덱스
		 *  	length 	: 복사 할 개수 
		 **********************************************************/
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for(int i=0; i<newStrArray.length; i++)
		{
			System.out.print(newStrArray[i] + ", ");
		}
	}	

}
