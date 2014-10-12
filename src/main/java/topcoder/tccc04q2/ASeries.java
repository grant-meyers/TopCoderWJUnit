package topcoder.tccc04q2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/* Incomplete answer to 2004 TCCC Qualification Problem Set 2 - Division I, Level One
 * http://community.topcoder.com/stat?c=problem_statement&pm=1758
 */

public class ASeries {

	public static void main(String[] args) {		
		int[] test =	{500000, 490000, 480000, 470000, 460000, 440000, 430000, 420000, 410000, 400000, 380000, 370000, 360000, 350000, 340000, 320000, 310000, 300000, 290000, 280000};
		
		System.out.println(ASeries.longest(test));
	}

		public static int longest(int[] values)
		{
			List<Integer> sortedValues = new ArrayList<Integer>(values.length);
			
			for(int curVal : values)
			{
				sortedValues.add(curVal);
			}
			
			Collections.sort(sortedValues);
			
			System.out.println(sortedValues);
			
			int bestSeries = 0;
			
			for(int i=0; i<sortedValues.size()-1; i++) {
				int curBest = 2;
				
				//Forward scan
				for(int j=i+1; j<sortedValues.size(); j++) {
					int hopSize = sortedValues.get(j) - sortedValues.get(i);
					
					int curTestValue = hopSize + sortedValues.get(j);
					for(int k=1; k<sortedValues.size()-j; k++) {
						if(sortedValues.get(j+k) == curTestValue) {
							curBest = curBest + 1;
							curTestValue = sortedValues.get(j+k) + hopSize;
						}else{
							break;
						}
					}
					
					if(curBest > bestSeries) {
						bestSeries = curBest;
					}
					curBest = 2;
				}
				
				//Backward scan
				
				if(curBest > bestSeries) {
					bestSeries = curBest;
				}
			}
			
			return bestSeries;
		}
}
