/* Created as an answer to Single Round Match 203 Round 1 - Division II, Level One
 * http://community.topcoder.com/stat?c=problem_statement&pm=2913&rd=5849
 */

package topcoder.m203r1d2l1;

public class UserName {
	public String newMember(String[] existingNames, String newName) {
		String foundName = new String(newName);
		boolean uniqueName = false;
		
		while(!uniqueName)
		{
			uniqueName = true;
			
			for(String cur : existingNames) {
				if(cur.compareTo(foundName) == 0){
					uniqueName = false;
				}
			}
			
			if(uniqueName) { return foundName; }
			
				int copyIndex = foundName.length();
				
				for(int i=0; i<foundName.length(); i++)
				{
					if(!Character.isAlphabetic(foundName.charAt(i)))
					{
						copyIndex = i;
						break;
					}
				}
				
				if(copyIndex == foundName.length())
				{
					foundName = new String(foundName + "1");
					continue;
				}else{
					String temp = foundName.substring(copyIndex);
					int newNumber = Integer.parseInt(temp) + 1;
					foundName = new String(foundName.substring(0, copyIndex) + Integer.toString(newNumber));
				}
			}
			
		return foundName;
	}

}
