/* Created as an answer to Single Round Match 347 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=7741
 */

package topcoder.m347r1d1l1;

public class Aircraft {
		public String nearMiss(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
			String ret = "NO";
			
			int rSquared = (int)Math.pow(R, 2);
			double x1, x2, y1, y2, z1, z2;
			
			for(int t=0; t<20000; t++) {
				x1 = p1[0] + v1[0] * t;
				x2 = p2[0] + v2[0] * t;
				y1 = p1[1] + v1[1] * t;
				y2 = p2[1] + v2[1] * t;
				z1 = p1[2] + v1[2] * t;
				z2 = p2[2] + v2[2] * t;				
				
				if((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2)) <= rSquared) {
					System.out.println("Time: " + t);
					return "YES";
				}
			}
			
			
			return ret;
	}
}
