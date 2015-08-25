// Time O(n)   Space O(logn)
public List<Integer> inorderTraversal(TreeNode root) {

	List<Integer> inorder = new ArrayList<Integer>();
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

	while (!stack.isEmpty() || root != null) {

		if (root != null) {
			stack.push(root);
			root = root.left;
		} else {
			root = stack.pop();
			inorder.add(root.val);
			root = root.right;
		}
	}
	return inorder;
}

// Morris Traversal: Space O(1)
public List<Integer> inorderTraversal(TreeNode root) {

	List<Integer> inorder = new ArrayList<Integer>();
	TreeNode curr = root;
	TreeNode prev = null;

	while (curr != null) {

		if (curr.left == null) {
			inorder.add(curr.val);
			curr = curr.right;
		} else {
			prev = curr.left;
			while (prev.right != null && prev.right != curr) {
				prev = prev.right;
			}

			if (prev.right == null) {
				prev.right = curr;
				curr = curr.left;
			} else {
				prev.right = null;
				inorder.add(curr.val);
				curr = curr.right;
			}
		}
	}
	return inorder;
}