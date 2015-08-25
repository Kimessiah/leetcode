// Time O(n)   Space O(logn)
public List<Integer> postorderTraversal(TreeNode root) {
	
	List<Integer> postorder = new ArrayList<>();

	LinkedList<TreeNode> stack = new LinkedList<>();

	TreeNode prev = null;

	while (root != null || !stack.isEmpty()) {

		if (root != null) {
			stack.push(root);
			root = root.left;
		} else {
			TreeNode curr = stack.peek();

			if (curr.right != null && prev != curr.right) {
				root = curr.right;
			} else {
				stack.pop();
				postorder.add(curr.val);
				prev = curr;
			}

		}
	}
	return postorder;
}

// Time O(n)   Space O(1)
public List<Integer> postorderTraversal(TreeNode root) {

}