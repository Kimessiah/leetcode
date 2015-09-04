// Time O(n)
int count;
int val;

public int kthSmallest(TreeNode root, int k) {

	if (root == null || k < 1) return 0;

	count = k;
	helper(root);
	return val;
}

void helper(TreeNode root) {

	if (root == null) return;

	helper(root.left);
	if (--count == 0) {
		val = root.val;
		return;
	}
	helper(root.right);
}

// Iterative: Time O(n)
public int kthSmallest(TreeNode root, int k) {

	if (root == null || k < 1) return 0;

	Stack<TreeNode> stack = new Stack<>();

	while (root != null) {
		stack.push(root);
		root = root.left;
	}

	while (!stack.isEmpty()) {

		TreeNode curr = stack.pop();

		if (--k == 0) return curr.val;

		TreeNode rightChild = curr.right;

		while (rightChild != null) {
			stack.push(rightChild);
			rightChild = rightChild.left;
		}
	}
	return 0;
}