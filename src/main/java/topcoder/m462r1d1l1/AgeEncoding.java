/* Created as an answer to Single Round Match 462 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=10589
 */

package topcoder.m462r1d1l1;

public class AgeEncoding {
		public double getRadix(int age, String candlesLine) {
			double lowBase = 0.0;
			double hiBase = age;
			double curBase = (hiBase + lowBase) / 2;
			final int MAX_ITERATIONS = 100;
			int currentIterationCount = 0;
			
			while(Math.abs(getStringValue(candlesLine, curBase, (double)age) - (double)age) > 0.000000001) {
				curBase = (hiBase + lowBase) / 2;
				
				double direction = getStringValue(candlesLine, curBase, (double)age) - (double)age;
								
				if(direction > 0.0) {
					hiBase = curBase - Double.MIN_NORMAL;
				}
				
				if(direction < 0.0) {
					lowBase = curBase + Double.MIN_NORMAL;
				}
				
				if(currentIterationCount++ > MAX_ITERATIONS) { 
					System.out.println("Reached Maximum Iterations.");
					return -1; 
				}
				
			}
			
			return curBase;
		}
		
		private double getStringValue(String candles, double base, double targetAge) {
			
			double ret = 0.0;
			double power = candles.length() - 1;
			
			for(char cur : candles.toCharArray()) {
				if(cur == '1') {					
					ret = ret + Math.pow(base,  power);
				}
				power = power - 1.0;
			}
			System.out.println("Testing: " + ret + " Base: " + base);
			return ret;
		}
}
