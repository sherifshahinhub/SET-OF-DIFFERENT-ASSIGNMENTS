package iceHocky;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
	
public class Ho_Class implements IPlayersFinder {
	 char [][]tda ; //Two Dimentional Array
	 int [][] boolArr ;
	 int [][]found ;
	 int trueCount = 0;
	 int I = 0,A = 0, B = 0;
	 int [][] visited ;
	 int visitedCount = 0;
	 int count ;
	 int [][][]thirdDimention;
	 int threedCount ;
	 int Rvisited[][] ;
	 int Rv = 0 ;
	 
	public  Point[] findPlayers(String[] photo, int team, int threshold) {
		if (photo.length == 0){
			Point[] center = new Point[0];
			 return center ;
		}
		
		tda = new char [photo.length][photo[0].length()];
		boolArr = new int [photo.length][photo[0].length()];
		for (int i = 0 ; i < photo.length ;i++){
			tda[i] = photo[i].toCharArray();
		}
		threedCount = 0 ;
	    char cteam = Character.forDigit(team, 10);
		
		for (int i = 0 ;i < tda.length ; i++){
			for (int j = 0; j < tda[0].length ; j++){
				if (tda[i][j] == cteam){
					boolArr[i][j] = 1 ;
					trueCount++;
				}
				else{
					boolArr[i][j] = 0 ;
				}
			}
		}
		
		
		found = new int [trueCount][2];
		for (int i = 0 ;i < tda.length ; i++){
			for (int j = 0 ;j < tda[0].length ; j++){
				if (tda[i][j] == cteam){
					found[I][0] = i;
					found[I][1] = j;
					I++;
				}
				}
			
		}
		visited = new int [I][2];
		Rvisited = new int [I][2];
		thirdDimention = new int [100][I][2];
		
			for (int j = 0 ;j < I ; j++){
				for (int k = 0 ;k < 2 ; k++)
				visited [j][k] = -1 ;
			
		}
		count = 0;
		for (int x = 0 ;x < boolArr[0].length; x++){
			for (int y = 0 ; y < boolArr.length ; y++){
				boolean c = check(x,y);
				if (c == true){
					continue ;
				}
				else{
				count = 0 ;
				for (int j = 0 ;j < I ; j++){
					for (int k = 0 ;k < 2 ; k++)
					visited [j][k] = -1 ;	
		        	}
				search(x,y);
				Rvisited[Rv][0] = visited[0][0];Rvisited[Rv][1] = visited[0][1];
				Rv++ ;
				int M =0;
				float g = (float)threshold/4;
				if (g != threshold/4){
					M =(int) g;
					M++;
				}
				else
					M = (int)g ;
				if (check2(x,y) == false && count >= M ){  
				
				for (int i = 0 ;i < I; i++){
						thirdDimention[threedCount][i][0] = visited[i][0];
						thirdDimention[threedCount][i][1] = visited[i][1];
				}
				threedCount++ ;
				
				}
				
			  }
			 }

			}
	
			return Centers(thirdDimention);  
		  
	}
	
//---------------------------------------------------------------------------------------------------------------
	Point []Centers (int Arr[][][]){
	//	System.out.println(threedCount);
		
		 Point[] center = new Point[threedCount];
			for(int j = 0; j < center.length; j++) {
			    center[j] = new Point();
			}
		  
		 int II = 0;
		 
		 for (int i = 0 ; i < threedCount ; i++){
			 int maxX = Arr[i][0][1] , maxY = Arr[i][0][0] , minX = Arr[i][0][1] , minY = Arr[i][0][0] ;
				for(int j = 0 ; j < I ; j++){
					if (Arr[i][j][0] == -1){
					   continue ;
					}
					maxX = Math.max(maxX, Arr[i][j][1]);
					maxY = Math.max(maxY, Arr[i][j][0]);
					minX = Math.min(minX, Arr[i][j][1]);
					minY = Math.min(minY, Arr[i][j][0]);

				}
				boolean found = false;
				for (int k = 0 ; k < i ; k++){
					if (center[k].x == 0)
						found = true ;
					if (center[k].x ==(maxX + minX + 1) && center[k].y == (int)(maxY + minY + 1))
						found = true ; 
				}
				if (true){
				center[i].x = (int)(maxX + minX + 1) ;
				center[i].y = (int)(maxY + minY + 1) ;
				}
		 }
		Arrays.sort(center, new PointCmp2());
		Arrays.sort(center, new PointCmp());

		return center ;
	}
	
//**************************************************************************************************	
	void search(int x , int y){
		
		if ( x < 0	|| y < 0  || x >= boolArr[0].length || y >= boolArr.length|| boolArr[y][x] ==  0){
			return ;
		}
		
				for (int i = 0 ; i < I; i++){
					if (visited[i][1] == x && visited[i][0] == y){
						return ;
					}
		         }
		if (check(x,y))
			return;
		
		visited [count][1] = x;
		visited [count][0] = y;
		count++;
		search(x + 1 , y);
		search(x - 1 , y);
		search(x , y + 1);
		search(x , y - 1);
	}
	boolean check (int x , int y){
		if (boolArr[y][x] == 0)
			return true ;
		    
			for (int j = 0 ; j < I; j++){
				if (visited [j][1] == x && visited [j][0] == y){
					return true ;
				}
			}
		
		return false ;
	}
	boolean check2 (int x , int y){
		for (int i = 0 ; i < threedCount ; i++){
			for(int j = 0 ; j < I ; j++){
				if (thirdDimention[i][j][0] == -1)
					continue ;
				
				if(thirdDimention[i][j][0] == visited[0][0] && thirdDimention[i][j][1] == visited[0][1])
					return true;
			}
	    }
		return false;
	}
	
	
}
//sorting
class PointCmp implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return (a.x < b.x) ? -1 : (a.x > b.x) ? 1 : 0;
    }
}
class PointCmp2 implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return (a.y < b.y) ? -1 : (a.y > b.y) ? 1 : 0;
    }
}
