// Time O(nlogn)
public int minMeetingRooms(Interval[] intervals) {
	
	if (intervals == null || intervals.length == 0) return 0;

	Arrays.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval interval1, Interval interval2) {
			return interval1.start - interval2.start;
		}
	});

	int rooms = 1;
	PriorityQueue<Integer> heap = new PriorityQueue<>();
	heap.offer(intervals[0].end);
	for (int i = 1; i < intervals.length; i++) {
		if (intervals[i].start < heap.peek()) {
			rooms++;
		} else {
			heap.poll();
		}
		heap.offer(intervals[i].end);
	}
	return rooms;
}