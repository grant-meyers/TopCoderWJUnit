package topcoder.tccc4q2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import topcoder.tccc4q2.NoZero;

@RunWith(Parameterized.class)
public class NoZeroTest {
	private int expected;
	private int big;
	private int small;
	private NoZero noZero;
	
	@Before
	public void initialize() {
		noZero = new NoZero();
	}
	
    public NoZeroTest(int inputBig, int inputSmall, int inputExpectedResult) {
    	this.big = inputBig;
    	this.small = inputSmall;
    	this.expected = inputExpectedResult;
    }
	
    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
       return Arrays.asList(new Object[][] {
    		   {111, 99, 1},
    		   {19, 11, 8},
    		   {191, 111, 79},
    		   {999999999, 1, 999999998},
    		   {9989, 1112, 8877},
    		   {11112, 9989, 12},
    		   {11, 1, 9},
    		   {999634343, 999634341, 2},
    		   {999634343, 77, 999634255},
    		   {999999927, 888888818, 99999998},
    		   {2, 1, 1},
    		   {111111111, 1, 99999999},
    		   {823987654, 123876543, 689111111},
    		   {143, 9, 133},
    		   {999, 9, 989},
    		   {11111, 9999, 1}
       });
    }
	
	@Test
	public void testNumberofRejections() {
		assertEquals(expected, noZero.subtract(big, small), 0);
	}
}
