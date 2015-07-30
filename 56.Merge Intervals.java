// Time O(nlogn + n)
public List<Interval> merge(List<Interval> intervals) {

	if (intervals == null || intervals.size() == 0) return intervals;

	Collections.sort(intervals, new Comparator<Interval> {
		@Override
		public int compare(Interval interval1, Interval interval2) {

			if(interval1.start == interval2.start) {
                return interval1.end - interval2.end;  
            }
			return interaval1.start - interaval2.start;
		}
	});

	List<Interval> res = new ArrayList<Interval>();
	res.add(intervals.get(0));

	for (int i = 1; i< intervals.size(); i++) {

		if (res.get(res.size()-1).end >= intervals.get(i).start) {
			res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
		} else {
			res.add(intervals.get(i));
		}
	}
	return res;	
}