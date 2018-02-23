package maze;

import java.io.File;

public class Main {
	   public static void main(String args[]){
		   MazeClass object = new MazeClass();
		   int arr[][] = object.solveBFS(new File("maze.txt"));
		   /**
		    * 
		    01234
		    ##..S 0
			..#.. 1
			.##.. 2
			E.... 3
			..### 4
			
		    * The maze is 0 indexed , We want a path from S to E
		    * The Expected output is:
		    *   0 4
				1 4
				2 4
				3 4
				3 3
				3 2
				3 1
				3 0
		    */
		   for (int i = 0; i < arr.length; i++) {
			   for (int j = 0; j < arr[i].length; j++) {
				 System.out.print(arr[i][j]);
			  }
			   System.out.println();
		   }
	   }
}
