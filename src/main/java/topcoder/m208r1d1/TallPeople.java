package topcoder.m208r1d1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/* Created as an answer to Single Round Match 208 Round 1 - Division I, Level One
 * http://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */


public class TallPeople {
	public int[] getPeople(String[] people) {		
		int tallestOfShort;
		int shortestOfTall;
		
		List<Integer> tallest = new ArrayList<Integer>();
		int entries = (people[0].split(" ")).length;
		
		for(String cur : people)
		{
			String[] curRow = cur.split(" ");
			
			int shortest = 100000;
			
			for(String curHeight : curRow)
			{
				if(Integer.parseInt(curHeight) < shortest)
				{
					shortest = Integer.parseInt(curHeight);
				}
			}
			tallest.add(shortest);
		}
		
		Collections.sort(tallest);
		tallestOfShort = tallest.get(tallest.size() - 1);
		
		tallest = null;
		tallest = new ArrayList<Integer>();
		
		for(int i=0; i<entries; i++)
		{
			int tall = -1;
			
			for(String cur : people)
			{
				String[] curRow = cur.split(" ");
				
				if(Integer.parseInt(curRow[i]) > tall)
				{
					tall = Integer.parseInt(curRow[i]);
				}						
			}
			tallest.add(tall);			
		}

		Collections.sort(tallest);
		shortestOfTall = tallest.get(0);
		
		int[] ret = {tallestOfShort, shortestOfTall};
		return ret;
	}
}
