public class RectangleSumZero {

	static int maxX1 = -1, maxX2 = -1, maxY1 = -1, maxY2 = -1, max = -1;

	public static void main(String[] args) {
		int array[][] = new int[][] { 
				{ 2 , 3  , 5 , 2},
				{-1 , 0  , 3 ,-4},
				{ 2 ,-3  ,-5 , 2},
				{-1 , -2  , 3 ,-4}
		};
		findZero(array, 4, 4);
	}

	public static void findZero(int[][] array, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int ii = row - 1; ii > i; ii--) {
					for (int jj = col - 1; jj > j; jj--) {
						findSum(array, i, j, ii, jj);

					}
				}
			}
		}
		if(max>-1)
			printSubMatrix(array);
	}

	private static void printSubMatrix(int [][] array) {
		for(int i=maxX1; i<=maxX2;i++)
		{
			for(int j =maxY1; j<=maxY2; j++)
			{
				if(i==maxX2 || j==maxY2 || i==maxX1 || j==maxY1)
				System.out.print("   " + array[i][j]);
				else
					System.out.print("    ");
			}
			System.out.println();
		}
		
	}

	private static void findSum(int[][] array, int startingX, int startingY,
			int endingX, int endingY) {

		int sum = 0;
		int x = startingX;
		int y = startingY;
		try {

			while (startingY <= endingY)
			{
				sum = sum + array[startingX][startingY];
				sum = sum + array[endingX][startingY];
				startingY++;
			}
			startingY = y;
			while (startingX <= endingX)
			{
				sum = sum + array[startingX][startingY];
				sum = sum + array[startingX][endingY];
				startingX++;
			}
		}

		catch (Exception ex)
		{

			System.out.println("Exception [" + startingX + "] , [" + startingY
					+ "] \n[" + endingX + "] , [" + endingY + "]");
		}
		startingX = x;
		sum = sum - array[startingX][startingY] - array[startingX][endingY]
				- array[endingX][endingY] - array[endingX][startingY];
		System.out.println(sum);
		if (sum == 0)
		{
			 int localMax = (endingX - startingX + 1)* (endingY - startingY +1);
			 if(localMax > max)
			 {
				 max=localMax;
				 maxX1=startingX;
				 maxX2=endingX;
				 maxY1=startingY;
				 maxY2=endingY;
			 }
			System.out.println("[" + startingX + "] , [" + startingY + "] \n["
					+ endingX + "] , [" + endingY + "]");
		}
	}

}
