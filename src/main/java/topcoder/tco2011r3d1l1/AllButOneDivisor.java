/*Created as an answer to TCO 2011 Qualification Round 3 Div 1 Level One
* http://community.topcoder.com/stat?c=problem_statement&pm=11415
*/

package topcoder.tco2011r3d1l1;

public class AllButOneDivisor {
		public int getMinimum(int[] divisors) {
			int best = 999999999;
			int curBest = 1;
			
			for(int i=0; i<divisors.length; i++) {
				
				curBest = LCMless1(divisors, i);
				
				if(curBest % divisors[i] == 0) { continue; }
				
				if(curBest < best) { 
					best = curBest;
				}
			}
					
			if(best == 999999999) { return -1; }
			
			return best;
		}
	
	private int LCMless1(int[] elements, int skipIndex) {
		int ret = (skipIndex == 0)? elements[1] : elements[0];
		
		for(int i=1; i<elements.length; i++) {
			if(i == skipIndex) { continue; }
			ret = ret * (elements[i] / gcd(ret, elements[i]));
		}
		return ret;
	}
	
	private int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	    	int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
}
