/* Created as an answer to Single Round Match 191 Round 1 - Division II, Level One
 * http://community.topcoder.com/stat?c=problem_statement&pm=2297&rd=4775
 */

package topcoder.m191r1d2l1;

public class BettingMoney {
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult)
	{
		int ret = 0;
		
		for(int index : amounts)
		{
			ret = ret + index;
		}
		
		ret = ret * 100;
		ret = ret - (amounts[finalResult] * 100 + centsPerDollar[finalResult] * amounts[finalResult]);
		
		return ret;
	}
}	

