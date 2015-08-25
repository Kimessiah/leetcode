// Time O(n)   Space O(logn)
public boolean isBalanced(TreeNode root) {

	return helper(root) == -1 ? false : true;
}

int helper(TreeNode root) {

	if (root == null) return 0;

	int leftHeight = helper(root.left);

	if (leftHeight == -1) return -1;

	int rightHeight = helper(root.right);

	if (rightHeight == -1) return -1;

	if (Math.abs(leftHeight - rightHeight) > 1) return -1;

	return 1 + Math.max(leftHeight, rightHeight);
}