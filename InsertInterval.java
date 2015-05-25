import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Chris
 * 
 */
public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null) {
			return intervals;
		} else if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		int toFind = newInterval.start;
		int left = 0, right = intervals.size() - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (intervals.get(mid).start == toFind) {
				left = mid;
				break;
			} else if (toFind > intervals.get(mid).start) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (toFind >= intervals.get(left).start) {
			// insert in left + 1
			intervals.add(left + 1, newInterval);
		} else {
			// insert in left
			intervals.add(left, newInterval);
		}

		List<Interval> list = new ArrayList<Interval>();
		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (last.end >= intervals.get(i).start) {
				if (last.end <= intervals.get(i).end) {
					last.end = intervals.get(i).end;
				}
			} else {
				Interval toAdd = new Interval(last.start, last.end);
				list.add(toAdd);
				last.start = intervals.get(i).start;
				last.end = intervals.get(i).end;
			}
		}
		Interval toAdd = new Interval(last.start, last.end);
		list.add(toAdd);
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		[[2,3],[5,5],[6,6],[7,7],[8,11]]
		Interval interval1 = new Interval(2,3);
		Interval interval2 = new Interval(5,5);
		Interval interval3 = new Interval(6,6);
		Interval interval4 = new Interval(7,7);
		Interval interval5 = new Interval(8,11);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		
		Interval newInterval = new Interval(6, 13);
		
		List<Interval> list = insert(intervals, newInterval);
		System.out.println("list = " + list);

	}

}
