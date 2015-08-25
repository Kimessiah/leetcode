public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (root == null) return res;

	LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	curr.push(root);

	List<Integer> item = new ArrayList<Integer>();

	int level = 0;

	while (!curr.isEmpty()) {

		while (!curr.isEmpty()) {

			TreeNode n = curr.pop();

			if (level % 2 == 0) {
				if (n.left != null) {
					next.push(n.left);
				} 
				if (n.right != null) {
					next.push(n.right);
				}

			} else {
				if (n.right != null) {
					next.push(n.right);
				}
				if (n.left != null) {
					next.push(n.left);
				} 
			}
			item.add(n.val);
		}
		
		res.add(item);
		curr = next;
		next = new LinkedList<TreeNode>();
		item = new ArrayList<Integer>();
		level++;
	}
	return res;
}