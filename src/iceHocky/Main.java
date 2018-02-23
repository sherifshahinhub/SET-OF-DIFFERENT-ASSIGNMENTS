package iceHocky;
import java.awt.Point;

public class Main {
   public static void main(String args[]){
	   Ho_Class h = new Ho_Class();
	   int team = 3;
	   int threshold = 16;
	   String[] photo = { 
			   "33JUBU33",
			   "3U3O4433",
			   "O33P44NB",
			   "PO3NSDP3",
			   "VNDSD333",
			   "OINFD33X"};
	    Point[] p = h.findPlayers(photo, team, threshold);
	    for (int i = 0; i < p.length; i++) {
			System.out.println("("+p[i].x+","+p[i].y+")" );
		}
	    System.out.println("----------------------------------------");
	    String[] photo2 = {
	    		"44444H44S4",
	    		"K444K4L444",
	    		"4LJ44T44XH",
	    		"444O4VIF44",
	    		"44C4D4U444",
	    		"4V4Y4KB4M4",
	    		"G4W4HP4O4W",
	    		"4444ZDQ4S4",
	    		"4BR4Y4A444",
	    		"4G4V4T4444"};
	    team = 4;
	    threshold = 16;
		    Point[] p1 = h.findPlayers(photo2, team, threshold);
		    for (int i = 0; i < p1.length; i++) {
				System.out.println("("+p1[i].x+","+p1[i].y+")" );
			}
		    System.out.println("----------------------------------------");
		    String[] photo3 = {
		    		"8D88888J8L8E888",
		    		"88NKMG8N8E8JI88",
		    		"888NS8EU88HN8EO",
		    		"LUQ888A8TH8OIH8",
		    		"888QJ88R8SG88TY",
		    		"88ZQV88B88OUZ8O",
		    		"FQ88WF8Q8GG88B8",
		    		"8S888HGSB8FT8S8",
		    		"8MX88D88888T8K8",
		    		"8S8A88MGVDG8XK8",
		    		"M88S8B8I8M88J8N",
		    		"8W88X88ZT8KA8I8",
		    		"88SQGB8I8J88W88",
		    		"U88H8NI8CZB88B8",
		    		"8PK8H8T8888TQR8"};
		    team = 8;
		    threshold = 9;
			    Point[] p2 = h.findPlayers(photo3, team, threshold);
			    for (int i = 0; i < p2.length; i++) {
					System.out.println("("+p2[i].x+","+p2[i].y+")" );
				}
			    System.out.println("----------------------------------------");
			    String[] photo4 = {
			    		"11111",
			    		"1AAA1",
			    		"1A1A1",
			    		"1AAA1",};
			    team = 1;
			    threshold = 3;
				    Point[] p3 = h.findPlayers(photo4, team, threshold);
				    for (int i = 0; i < p3.length; i++) {
						System.out.println("("+p3[i].x+","+p3[i].y+")" );
					}
   }
}
