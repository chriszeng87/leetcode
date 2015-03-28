import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 * 
 * @author Chris
 *
 */

class Interval  implements Comparable<Interval>{
	private int start;
	private int end;
	public Interval() {
		
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	
	
	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

	@Override
	public int compareTo(Interval o) {
		return this.getStart() - o.getStart();
	}
		
}

public class MergeIntervals {
	
	static List<Interval> getMergeIntervals(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return null;
		}
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(intervals);
		System.out.println(intervals);
			
		Interval toAdd = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).getStart() > toAdd.getEnd()) {
				result.add(toAdd);
				toAdd = intervals.get(i);
			} else {
				toAdd.setStart(toAdd.getStart());
				int oldEnd = toAdd.getEnd();
				toAdd.setEnd(Math.max(intervals.get(i).getEnd(), oldEnd));
			}
		}
		
		if (toAdd != null) {
			result.add(toAdd);
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		intervals.add(new Interval(2,6));
		
		System.out.println("result = " + getMergeIntervals(intervals));

	}

}
