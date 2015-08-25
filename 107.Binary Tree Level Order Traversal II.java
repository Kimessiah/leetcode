public List<List<Integer>> levelOrderBottom(TreeNode root) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (root == null) return res;

	Queue<TreeNode> curr = new LinkedList<TreeNode>();
	Queue<TreeNode> next = new LinkedList<TreeNode>();
	curr.add(root);
	List<Integer> level = new ArrayList<Integer>();

	while (!curr.isEmpty()) {

		TreeNode n = curr.poll();
		if (n.left != null) {
			next.add(n.left);
		}
		if (n.right != null) {
			next.add(n.right);
		}

		level.add(n.val);

		if (curr.isEmpty()) {
			res.add(level);
			curr = next;
			next = new LinkedList<TreeNode>();
			level = new ArrayList<Integer>();
		}
	}
	Collections.reverse(res);
	return res;
}