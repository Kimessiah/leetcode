public int[] findOrder(int numCourses, int[][] prerequisites) {

	if (prerequisites == null) return new int[0];

	int[] courses = new int[numCourses];
	for (int i = 0; i < prerequisites.length; i++) {
		courses[prerequisites[i][0]]++;
	}

	Queue<Integer> queue = new LinkedList<>();
	for (int i = 0; i < numCourses; i++) {
		if (courses[i] == 0) {
			queue.offer(i);
		}
	}

	int count = queue.size();
	int[] res = new int[numCourses];
	int j = 0;
	while (!queue.isEmpty()) {
		int preCourse = queue.poll();
		res[j++] = preCourse;
		for (int i = 0; i < prerequisites.length; i++) {
			if (prerequisites[i][1] == preCourse) {
				if (--courses[prerequisites[i][0]] == 0) {
					queue.offer(prerequisites[i][0]);
					count++;
				}
			}
		}
	}
	return count == numCourses ? res : new int[0];        
}