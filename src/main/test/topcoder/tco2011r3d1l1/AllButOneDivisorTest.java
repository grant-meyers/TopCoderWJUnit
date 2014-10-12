package topcoder.tco2011r3d1l1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AllButOneDivisorTest {
	private int expected;
	private int[] divisors;
	private AllButOneDivisor div;
	
	@Before
	public void initialize() {
		div = new AllButOneDivisor();
	}
	
	public AllButOneDivisorTest(int[] inputDivisors, int inputExpectedResult) {
    	this.divisors = inputDivisors;
    	this.expected = inputExpectedResult;
    }
	
    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
       return Arrays.asList(new Object[][] {
    		   {new int[] {2, 3, 5}, 6},
    		   {new int[] {2, 4, 3, 9}, 12},
    		   {new int[] {3, 2, 6}, -1},
    		   {new int[] {6, 7, 8, 9, 10}, 360},
    		   {new int[] {10, 6, 15}, -1},
    		   {new int[] {10, 11, 12, 13, 14, 15}, 4620},
    		   {new int[] {2, 4, 6, 3}, 6},
    		   {new int[] {8, 9, 5, 7, 11, 13}, 27720},
    		   {new int[] {14, 15, 6}, 30},
    		   {new int[] {7, 14, 2}, -1},
    		   {new int[] {4, 3, 1, 12}, -1},
    		   {new int[] {1, 2}, 1},
    		   {new int[] {1, 2, 3}, 2},
    		   {new int[] {15, 14, 1}, 14},
    		   {new int[] {15, 14, 13, 1, 12}, 420},
    		   {new int[] {2, 4, 8, 6, 3}, 12},
    		   {new int[] {2, 4, 11, 6, 3}, 12},
    		   {new int[] {2, 4, 13, 6, 3}, 12},
    		   {new int[] {8, 9, 15, 7, 11, 13}, 27720},
    		   {new int[] {2, 3, 5, 6}, 6},
    		   {new int[] {1, 3, 2, 5, 4}, 12},
    		   {new int[] {4, 1, 5, 3, 2}, 12},
    		   {new int[] {3, 4, 2, 5, 1}, 12},
    		   {new int[] {2, 4, 3, 1, 5}, 12},
    		   {new int[] {2, 5, 6, 4, 1, 3}, 12},
    		   {new int[] {3, 1, 2, 4}, 4},
    		   {new int[] {8, 11, 5}, 40},
    		   {new int[] {14, 1, 6, 10, 5, 9}, 90},
    		   {new int[] {8, 14, 5, 11, 7}, 280},
    		   {new int[] {13, 7, 14, 15, 6, 9}, 630},
    		   {new int[] {9, 3, 4, 1, 5}, 36},
    		   {new int[] {11, 1}, 1},
    		   {new int[] {1, 4, 12, 3, 13}, 12},
    		   {new int[] {4, 2}, 2},
    		   {new int[] {5, 8, 14, 4}, 40},
    		   {new int[] {7, 13, 14}, 14},
    		   {new int[] {14, 15}, 14},
    		   {new int[] {5, 13, 10, 9, 7, 2}, 630},
    		   {new int[] {1, 2, 12, 13, 11}, 132},
    		   {new int[] {2, 3, 11, 12, 14, 1}, 84},
    		   {new int[] {9, 14, 5}, 45},
    		   {new int[] {11, 1, 9, 2}, 18},
    		   {new int[] {9, 8, 5, 2}, 40},
    		   {new int[] {4, 6}, 4},
    		   {new int[] {14, 6}, 6},
    		   {new int[] {13, 1, 5, 9, 7, 4}, 1260},
    		   {new int[] {11, 8, 15, 6, 4}, 120},
    		   {new int[] {4, 12, 11}, 12},
    		   {new int[] {7, 5, 9, 1, 11, 6}, 630},
    		   {new int[] {4, 9, 10, 3, 12}, 36},
    		   {new int[] {4, 10, 13, 12, 9}, 180},
    		   {new int[] {14, 4, 12, 13, 2}, 84},
    		   {new int[] {9, 2, 14}, 14},
    		   {new int[] {6, 3, 13, 7}, 42},
    		   {new int[] {2, 14, 4}, 4},
    		   {new int[] {5, 3, 7, 13, 4, 9}, 1260},
    		   {new int[] {7, 8, 11, 4}, 56},
    		   {new int[] {8, 10}, 8},
    		   {new int[] {4, 15, 12, 3}, 12},
    		   {new int[] {4, 11, 10, 9}, 180},
    		   {new int[] {7, 6, 8}, 24},
    		   {new int[] {2, 7, 11, 4}, 28},
    		   {new int[] {7, 1, 10, 15, 13}, 210},
    		   {new int[] {4, 10, 14, 6, 9}, 180},
    		   {new int[] {11, 10, 13, 9, 3, 5}, 990},
    		   {new int[] {2, 15, 12}, 12},
    		   {new int[] {10, 1, 2, 3}, 6},
    		   {new int[] {2, 3, 6, 11}, 6},
    		   {new int[] {2, 10, 12, 9, 8}, 72},
    		   {new int[] {2, 11, 15, 5}, 30},
    		   {new int[] {11, 10, 14, 4, 2}, 140},
    		   {new int[] {2, 8, 10, 3, 13, 7}, 840},
    		   {new int[] {9, 7, 3, 11, 14}, 126},
    		   {new int[] {6, 10, 5, 3, 1}, -1},
    		   {new int[] {3, 9, 5, 4}, 36},
    		   {new int[] {14, 2, 4, 11, 7, 6}, 84},
    		   {new int[] {12, 9, 4, 5}, 36},
    		   {new int[] {15, 2, 9, 5}, 30},
    		   {new int[] {8, 11, 7, 10, 1}, 280},
    		   {new int[] {12, 14, 13, 4}, 84},
    		   {new int[] {8, 7, 2, 3, 1, 10}, 120},
    		   {new int[] {10, 12, 7, 14, 9, 5}, 420},
    		   {new int[] {14, 7, 9, 11, 8}, 504},
    		   {new int[] {1, 9, 7, 4, 2, 14}, 28},
    		   {new int[] {1, 15, 9, 5, 3, 11}, 45},
    		   {new int[] {11, 6, 13, 1}, 66},
    		   {new int[] {10, 11, 14, 12}, 420},
    		   {new int[] {9, 7, 12, 14, 10}, 252},
    		   {new int[] {15, 7, 12, 10, 11, 14}, 420},
    		   {new int[] {9, 15, 13, 11, 12, 10}, 1980},
    		   {new int[] {15, 11, 8, 14}, 616},
    		   {new int[] {14, 8, 9, 7, 13}, 504},
    		   {new int[] {13, 7, 12, 9, 15, 14}, 1260},
    		   {new int[] {11, 7, 13, 14, 12, 15}, 4620},
    		   {new int[] {12, 7, 15, 9, 13, 8}, 2520},
    		   {new int[] {11, 13, 15, 14}, 2002},
    		   {new int[] {11, 14, 13, 9, 12, 10}, 13860},
    		   {new int[] {9, 15, 12, 13, 11, 8}, 3960},
    		   {new int[] {12, 8, 11, 9, 13, 15}, 3960},
    		   {new int[] {8, 10, 14, 11, 12}, 840},
    		   {new int[] {10, 15, 14, 8}, 120},
    		   {new int[] {15, 13, 9, 11}, 495},
    		   {new int[] {10, 14, 8, 11}, 280},
    		   {new int[] {14, 11, 9, 13}, 1287},
    		   {new int[] {7, 9, 13, 11}, 693},
    		   {new int[] {12, 8, 11, 14, 13, 15}, 9240},
    		   {new int[] {7, 13, 11, 14, 9}, 1386},
    		   {new int[] {1, 2}, 1},
    		   {new int[] {1, 3, 4}, 3},
    		   {new int[] {2, 3, 7}, 6},
    		   {new int[] {2, 4}, 2},
    		   {new int[] {2, 3, 5, 15}, 15},
    		   {new int[] {5, 10, 13}, 10},
    		   {new int[] {3, 2, 6}, -1},
    		   {new int[] {10, 2, 3}, 6},
    		   {new int[] {5, 7, 8, 9, 11, 13}, 27720},
    		   {new int[] {2, 3, 4, 6, 7}, 12},
    		   {new int[] {5, 7}, 5},
    		   {new int[] {6, 7, 15}, 30},
    		   {new int[] {4, 5, 6}, 12},
    		   {new int[] {3, 6, 13}, 6},
    		   {new int[] {1, 2, 4, 8}, 4},
    		   {new int[] {13, 11, 9, 8, 7, 5}, 27720},
    		   {new int[] {1, 5}, 1},
    		   {new int[] {2, 4, 8}, 4},
    		   {new int[] {2, 3}, 2},
    		   {new int[] {6, 7, 8, 9, 10}, 360},
    		   {new int[] {13, 11, 7, 5, 9, 4}, 13860},
    		   {new int[] {6, 10, 15, 14}, 30},
    		   {new int[] {3, 5, 7, 11, 13}, 1155},
    		   {new int[] {3, 13, 2}, 6},
    		   {new int[] {2, 1}, 1},
    		   {new int[] {7, 10, 15}, 30},
    		   {new int[] {15, 14, 13, 12, 11, 10}, 4620}
       });
    }

	
	@Test
	public void testGetMinimum() {
		assertEquals(expected, div.getMinimum(divisors), 0);
	}

}