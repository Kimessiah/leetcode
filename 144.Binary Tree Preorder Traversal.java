// Time O(n)   Space O(logn)
public List<Integer> preorderTraversal(TreeNode root) {

	List<Integer> preorder = new ArrayList<>();

	if (root == null) return preorder;

	LinkedList<TreeNode> stack = new LinkedList<>();

	while (root != null || !stack.isEmpty()) {

		if (root != null) {
			preorder.add(root.val);

			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;
		} else {
			root = stack.pop();
		}
	}
	return preorder;
}

// Time O(n)   Space O(1)
public List<Integer> preorderTraversal(TreeNode root) {

	List<Integer> preorder = new ArrayList<>();

	TreeNode curr = root;
	TreeNode prev = null;

	while (curr != null) {

		if (curr.left == null) {
			preorder.add(curr.val);
			curr = curr.right;
		} else {
			prev = curr.left;

			while (prev.right != null && prev.right != curr) {
				prev = prev.right;
			}

			if (prev.right == null) {
				preorder.add(curr.val);
				prev.right = curr;
				curr = curr.left;
			} else {
				prev.right = null;
				curr = curr.right;
			}
		}
	}
	return preorder;
}