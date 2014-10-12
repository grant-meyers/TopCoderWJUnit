/* Created as an answer to 2004 TCCC Qualification Problem Set 2 Division 1 Level 2
 * http://community.topcoder.com/stat?c=problem_statement&pm=1107
 */

package topcoder.tccc4q2;

public class NoZero {
		public int subtract(int big, int small) {			
			String curValue;
			int difference = 0;
			int valueTest = small + 1;
			
			while(true) {
				curValue = String.valueOf(valueTest);
				if(curValue.indexOf('0') != -1) { valueTest++; continue; }
				
				difference++;
				
				if(valueTest == big) {
					valueTest++;
					break;
				}
				valueTest++;
			}
			
			int ret = difference;
			for(int i=1; i<=difference; i++) {
				if(String.valueOf(i).indexOf('0') != -1) {
					ret++;
				}
			}
						
			return ret;
	}
}
