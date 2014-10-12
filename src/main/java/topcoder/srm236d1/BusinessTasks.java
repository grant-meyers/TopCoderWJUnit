package topcoder.srm236d1;

import java.util.ArrayList;
import java.util.List;

/* Created as an answer to Single Round Match 236 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1585&rd=6535
 */

public class BusinessTasks {
	public String getTask(String[] list, int n)
	{
		List<String> circleList = new ArrayList<String>();
		
		for( String cur : list)
		{
			circleList.add(cur);
		}
				
		int remove = 0;
		while(circleList.size() > 1)
		{
			remove = (n+remove -1) % circleList.size();
			circleList.remove(remove);
		}
		
		return circleList.get(0);
	}

}
