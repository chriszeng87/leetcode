import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author Chris
 * 
 */

/**
 * Definition for an interval.
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new ArrayList<Interval>();
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				if (interval1.start == interval2.start) {
					return 0;
				} else if (interval1.start < interval2.start) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (last.end >= intervals.get(i).start) {
					if(last.end <= intervals.get(i).end) {
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
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 3));
		List<Interval> ret = merge(intervals);
		System.out.println("------ret = " + ret);
	}

}
