// BFS
public boolean canFinish(int numCourses, int[][] prerequisites) {
	
	if (prerequisites == null) return false;
	if (numCourses == 0 || prerequisites.length == 0) return true;

	int[] courses = new int[numCourses];
	for (int i = 0; i < prerequisites.length; i++) {
		courses[prerequisites[i][0]]++;
	}       

	Queue<Integer> queue = new LinkedList<>();
	for (int i = 0; i < courses.length; i++) {
		if (courses[i] == 0) {
			queue.offer(i);
		}
	}

	int count = queue.size();
	while (!queue.isEmpty()) {
		int preCourse = queue.poll();
		for (int i = 0; i < prerequisites.length; i++) {
			if (prerequisites[i][1] == preCourse) {
				if (--courses[prerequisites[i][0]] == 0) {
					queue.offer(prerequisites[i][0]);
					count++;
				}
			}
		}
	}
	return count == numCourses;
}

// DFS
public boolean canFinish(int numCourses, int[][] prerequisites) {

	if (prerequisites == null) return false;
	if (numCourses == 0 || prerequisites.length == 0) return true;

	int[] visited = new int[numCourses];
	Map<Integer, List<Integer>> map = new HashMap<>();
	for (int[] courses : prerequisites) {
		if (map.containsKey(courses[1])) {
			map.get(courses[1]).add(courses[0]);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(courses[0]);
			map.put(courses[1], list);
		}
	}

	for (int i = 0; i < numCourses; i++) {
		if (!dfs(map, visited, i)) {
			return false;
		}
	}
	return true;
}

boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int i) {

	if (visited[i] == -1) return false;
	if (visited[i] == 1) return true;

	visited[i] = -1;
	if (map.containsKey(i)) {
		for (int j : map.get(i)) {
			if (!dfs(map, visited, j)) {
				return false;
			}
		}
	}
	visited[i] = 1;
	return true;
}