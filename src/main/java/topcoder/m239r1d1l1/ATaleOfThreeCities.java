/* Created as an answer to Single Round Match 239 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=3543
 */

package topcoder.m239r1d1l1;

public class ATaleOfThreeCities {
		public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
			double ret = 0.0;

			double bestAB = 10000.0, bestBC = 10000.0, bestAC = 10000.0;
			
			//Generate A-B
			for(int i=0; i<ax.length; i++) {
				double curBestAB;
				
				if(ax[i] == Integer.MAX_VALUE) { continue; }
				
				for(int j=0; j<bx.length; j++) {
					if(bx[i] == Integer.MAX_VALUE) { continue; }
					
					curBestAB = Math.sqrt(Math.pow((double)bx[j]-(double)ax[i], 2) + Math.pow((double)by[j]-(double)ay[i], 2));
					
					if(curBestAB < bestAB) {
						bestAB = curBestAB;
					}
				}
			}
			
			//Generate A-C
			for(int i=0; i<ax.length; i++) {
				double curBestAC;

				if(ax[i] == Integer.MAX_VALUE) { continue; }
				
				for(int j=0; j<cx.length; j++) {
					if(cx[i] == Integer.MAX_VALUE) { continue; }
					
					curBestAC = Math.sqrt(Math.pow((double)cx[j]-(double)ax[i], 2) + Math.pow((double)cy[j]-(double)ay[i], 2));
					
					if(curBestAC < bestAC) {
						bestAC = curBestAC;
					}
				}
			}
			//Generate B-C
			for(int i=0; i<bx.length; i++) {
				double curBestBC;
				
				if(bx[i] == Integer.MAX_VALUE) { continue; }
				
				for(int j=0; j<cx.length; j++) {
					if(cx[i] == Integer.MAX_VALUE) { continue; }
					
					curBestBC = Math.sqrt(Math.pow((double)bx[j]-(double)cx[i], 2) + Math.pow((double)by[j]-(double)cy[i], 2));
					
					if(curBestBC < bestBC) {
						bestBC = curBestBC;
					}
				}
			}
			
			double pathABC = bestAB + bestBC;
			double pathACB = bestAC + bestBC;
			double pathBAC = bestAB + bestAC;
			
			ret = Math.min(Math.min(pathABC, pathACB), pathBAC);
						
			return ret;
		}	
}
