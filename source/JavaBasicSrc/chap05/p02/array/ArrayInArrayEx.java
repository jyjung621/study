package p02.array;

public class ArrayInArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mathScores = new int[2][3];
		
		System.out.println("mathScores.length = " + mathScores.length);
		for(int i=0; i<mathScores.length; i++)
		{
			System.out.println("mathScores.length[" + i + "] = " + mathScores[i].length);
			for(int k=0; k<mathScores[i].length; k++)
			{
				System.out.println("mathScores[" + i + "][" + k + "] = " + mathScores[i][k]);
			}
		}
		System.out.println("mathScores Addr = " + mathScores);
		System.out.println("mathScores[0] Addr = " + mathScores[0]);
		System.out.println("mathScores[1] Addr = " + mathScores[1]);
		System.out.println();
		
		
		int [][] englishScores = new int [2][];
		
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		
		for(int i=0; i<englishScores.length; i++)
		{
			System.out.println("englishScores.length[" + i + "] = " + englishScores[i].length);
			for(int k=0; k<englishScores[i].length; k++)
			{
				System.out.println("englishScores[" + i + "][" + k + "] = " + englishScores[i][k]);
			}
		}
		System.out.println("englishScores Addr = " + englishScores);
		System.out.println("englishScores[0] Addr = " + englishScores[0]);
		System.out.println("englishScores[1] Addr = " + englishScores[1]);
		System.out.println();
		
		
		int [][] javaScores = {{95,80}, {92,96,80}};
		
		for(int i=0; i<javaScores.length; i++)
		{
			for(int k=0; k<javaScores[i].length; k++)
			{
				System.out.println("javaScores[" + i + "][" + k + "] = " + javaScores[i][k]);
			}
		}
		
	}

}
