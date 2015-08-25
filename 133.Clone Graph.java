// DFS: Time O(n)  Space O(n) 
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

	if (node == null) return null;

	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
	return dfs(node, map);
}

UndirectedGraphNode dfs(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map) {

	if (map.containsKey(graph)) {
		return map.get(graph);
	}

	UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
	map.put(graph, graphCopy);

	for (UndirectedGraphNode neighbor : graph.neighbors) {
		graphCopy.neighbors.add(dfs(neighbor, map));
	}
	return graphCopy;
}

// BFS: Time O(n)   Space O(n)
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

	if (node == null) return null;

	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	Queue<UndirectedGraphNode> queue = new LinkedList<>();
	queue.offer(node);

	UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
	map.put(node, graphCopy);

	while (!queue.isEmpty()) {

		UndirectedGraphNode n = queue.poll();

		for (UndirectedGraphNode neighbor : n.neighbors) {

			if (map.containsKey(neighbor)) {
				map.get(n).neighbors.add(map.get(neighbor));
			} else {
				UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor, neighborCopy);
				map.get(n).neighbors.add(neighborCopy);	
				queue.offer(neighbor);			
			}
		}
	}
	return graphCopy;
}