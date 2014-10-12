package topcoder.tchs07r3d1l1;

import java.util.Set; 
import java.util.TreeSet; 

/* Created as an answer to Top Coder
 * http://community.topcoder.com/stat?c=problem_statement&pm=7558
 */

public class AdvertisingAgency {
		public int numberOfRejections(int[] requests) {
			int ret = 0;
			
			Set<Integer> billboards = new TreeSet<Integer>();
			
			for(int cur : requests) {
				billboards.add(cur);
			}
			
			ret = requests.length - billboards.size();
			
			return ret;
	}
}
