// Time O(n^2)   Space O(n)
public int maxPoints(Point[] points) {

	if (points == null || points.length == 0) return 0;

	Map<Double, Integer> map = new HashMap<>();

	int max = 1;

	for (int i = 0; i < points.length-1; i++) {

		map.clear();

		// maybe all points contained in the list are same points, and same points' k is 
        // represented by Integer.MIN_VALUE
		map.put((double) Integer.MIN_VALUE, 1);

		int dup = 0;
		for (int j = i+1; j < points.length; j++) {

			if (points[i].x == points[j].x 
				&& points[i].y == points[j].y) {
				dup++;
				continue;
			}

			// for 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
            // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 != -0.0
            // problem
			double key = points[i].x == points[j].x ?
				Integer.MAX_VALUE : 
				0.0 + (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);

			if (map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 2);
			}
		}

		for (int n : map.values()) {
			if (n + dup > max) {
				max = n + dup;
			}
		}
	}
	return max;
}