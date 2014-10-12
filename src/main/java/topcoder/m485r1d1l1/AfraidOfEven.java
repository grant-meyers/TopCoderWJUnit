package topcoder.m485r1d1l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Created as an answer to Member Single Round Match 485 Round 1 - Division I, Level One 
 * http://community.topcoder.com/stat?c=problem_statement&pm=11146
 */

public class AfraidOfEven {
		public int[] restoreProgression(int[] seq) {
			int[] ret = {};
			
			boolean inSequence = testSequence(seq);
			
			if(inSequence) {
				System.out.println("In Sequence");
				return seq;
			}
			
			//Generate Delta
			List<possibility> deltas = new ArrayList<possibility>();
			for(int i=0; i<seq.length; i++) {
				for(int j=i+1; j<seq.length; j++){
					deltas.add( new possibility((seq[j] - seq[i])/(j-i), i ));
				}
			}

			Collections.sort(deltas); 
			
			//Generate Sequences
			int[] ascSeq = seq.clone();
			int[] descSeq = seq.clone();
			boolean ascendingSequence = true;
			
			for(possibility curDelta : deltas) {
				boolean validSequence = true;
				ascSeq = seq.clone();
				
				ascSeq = generateSequence(ascSeq, curDelta.anchorIndex, curDelta.deltaNum);
				
				if(testSequence(ascSeq) && ascSeq[0] != -10000) { return ascSeq; }
				
			}
			
			return (ascendingSequence) ? ascSeq : descSeq;
		}
		
		public boolean isOdd(int num) {
			return ((num % 2) == 0) ? true : false;
		}
		
		public boolean testSequence(int[] seq)
		{
			int stepSize = seq[1] - seq[0];
			boolean inSequence = true;
			
			for(int i=2; i<seq.length; i++) {
				if(seq[i] != (seq[i-1] + stepSize)) {
					inSequence = false; 
					break;
				}
			}
			return inSequence;
		}
		
		public int[] generateSequence(int[] source, int anchor, int delta) {
			
			int[] ret = source.clone();
			
			for(int i=1; i + anchor<source.length; i++) {
				ret[i+anchor] = source[anchor] + (i*delta);
				int temp = source[i+anchor];
				
				while(temp < ret[i+anchor]) {
					temp = temp << 1;
				}
				if(temp != ret[i+anchor]) { ret[0] = -10000; return ret; }
			}
			
			for(int i=1; anchor-i>=0; i++) {
				ret[anchor-i] = source[anchor] - (i*delta);
			}
			
			return ret;
		}
		
		private class possibility implements Comparable {
			public int anchorIndex;
			public int deltaNum;
			
			public int compareTo(Object p) {
				return deltaNum - ((possibility) p).deltaNum;
			}
			
			public possibility(int delta, int anchor) {
				anchorIndex = anchor;
				deltaNum = delta;
			}
		}
}
