/* Created as an answer to Single Round Match 292 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=4512
 */

package topcoder.m292r1d1l1;

public class Abacus {
		public String[] add(String[] original, int val) {
			String[] ret = {"","","","","",""};
			String[] retPossibilities = {
					"ooooooooo---",
					"oooooooo---o",
					"ooooooo---oo",
					"oooooo---ooo",
					"ooooo---oooo",
					"oooo---ooooo",
					"ooo---oooooo",
					"oo---ooooooo",
					"o---oooooooo",
					"---ooooooooo"};
			int abacusValue = 0;
			int threadMultiple = 100000;
			
			//Convert to decimal
				
			for(String curThread : original) {
				abacusValue = abacusValue + threadMultiple * (11 - curThread.lastIndexOf('-'));				
				threadMultiple = threadMultiple / 10;
			}
			
			//Addition
			abacusValue = abacusValue + val;
			System.out.println(abacusValue);
			
			threadMultiple = 100000;
			//Convert to Abacus
			for(int i=0; i<6; i++) {
				int retIndex = abacusValue/threadMultiple;
				ret[i] = retPossibilities[retIndex];
				abacusValue = abacusValue - (retIndex * threadMultiple);
				threadMultiple = threadMultiple / 10; 
			}
			
			return ret;
		}
}
