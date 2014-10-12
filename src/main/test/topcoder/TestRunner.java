package topcoder;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import topcoder.m191r1d2l1.BettingMoneyTest;
import topcoder.tco2011r3d1l1.AllButOneDivisorTest;
import topcoder.m239r1d1l1.ATaleOfThreeCitiesTest;

public class TestRunner {
	/*
	static int[][] nums = new int[][] {
		
	};

	public static void main(String[] args) {
		int i=0;
		
		for(int[] cur : nums) {
			System.out.println("Row: " + i++ + " Length: " + cur.length);
		}
	}*/
	
   public static void main(String[] args) {
      Result results[] = {
    		  JUnitCore.runClasses(ATaleOfThreeCitiesTest.class), 
    		  JUnitCore.runClasses(BettingMoneyTest.class), 
    		  JUnitCore.runClasses(AllButOneDivisorTest.class)
      };
      
      String classes[] = {
    	"ATaleOfThreeCities",
    	"BettingMoneyTest",
    	"AllButOneDivisorTest"
      };
      
      int i=0;
      
      for (Result cur : results) {
	      for (Failure failure : cur.getFailures()) {
	         System.out.println(failure.toString());
	      }

	      String ret = (cur.wasSuccessful()) ? "a success." : "a failure.";
	      
	      System.out.println("Testing " + classes[i++] + " was " + ret);
      }  
   }
}