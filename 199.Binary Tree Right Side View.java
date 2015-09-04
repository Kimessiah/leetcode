// Iterative
public List<Integer> rightSideView(TreeNode root) {

	List<Integer> res = new ArrayList<>();
	if (root == null) return res;

	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);

	while (!queue.isEmpty()) {
		int size = queue.size();

		for (int i = 0; i < size; i++) {
			TreeNode node = queue.poll();

			if (i == 0) {
				res.add(node.val);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
		}
	}
	return res;
}

// Recursive
public List<Integer> rightSideView(TreeNode root) {

	List<Integer> res = new ArrayList<>();
	dfs(res, root, 1);
	return res;
}

void dfs(List<Integer> res, TreeNode root, int level) {

	if (root == null) return;
	if (level > res.size()) {
		res.add(root.val);
	}

	dfs(res, root.right, level+1);
	dfs(res, root.left, level+1);
}

