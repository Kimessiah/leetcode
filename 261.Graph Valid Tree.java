// Union-Find
public boolean validTree(int n, int[][] edges) {

	int[] parent = new int[n];
	Arrays.fill(parent, -1);

	for (int i = 0; i < edges.length; i++) {

		int x = find(parent, edges[i][0]);
		int y = find(parent, edges[i][1]);

		if (x == y) return false;

		// union
		parent[x] = y;
	}

	return edges.length == n - 1;        
}

int find(int[] parent, int i) {

	if (parent[i] == -1) {
		return i;
	}
	return find(parent, parent[i]);
}

// DFS
public boolean validTree(int n, int[][] edges) {

	List<List<Integer>> adjList = new ArrayList<>();

	for (int i = 0; i < n; i++) {
		adjList.add(i, new ArrayList<>());
	}

	for (int i = 0; i < edges.length; i++) {
		int u = edges[i][0];
		int v = edges[i][1];

		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	boolean[] visited = new boolean[n];

	if (hasCycle(adjList, 0, visited, -1)) return false;

	for (int i = 0; i < n; i++) {
		if (!visited[i]) {
			return false;
		}
	}
	return true;
}

boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int u, int parent) {

	visited[u] = true;

	for (int i = 0; i < adjList.get(u).size(); i++) {

		int v = adjList.get(u).get(i);
		if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, visited, v, u))) {
			return true;
		}
	}

	return false;
}