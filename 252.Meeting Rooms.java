public boolean canAttendMeetings(Interval[] intervals) {
        
	if (intervals == null || intervals.length == 0) return true;

	Arrays.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval interval1, Interval interval2) {
			return interval1.end - interval2.end;
		}
	});

	for (int i = 0; i < intervals.length-1; i++) {
		if (intervals[i].end > intervals[i+1].start) {
			return false;
		}
	}
	return true;
}