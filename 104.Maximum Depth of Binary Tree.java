// Recursive: O(n)
public int maxDepth(TreeNode root) {

	if (root == null) return 0;

	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

// Iterative: O(n)
public int maxDepth(TreeNode root) {

	if (root == null) return 0;

	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);

	int currNum = 1;
	int nextNum = 0;

	int level = 0;

	while (!q.isEmpty()) {

		TreeNode n = q.poll();
		currNum--;

		if (n.left != null) {
			q.add(n.left);
			nextNum++;
		}
		if (n.right != null) {
			q.add(n.right);
			nextNum++;
		}

		if (currNum == 0) {
			currNum = nextNum;
			nextNum = 0;
			level++;
		}
	}
	return level;
}