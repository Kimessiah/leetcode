public boolean isValidBST(TreeNode root) {

	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

boolean helper(TreeNode root, int min, int max) {

	if (root == null) return true;

	if (root.val <= min || root.val >= max) return false;

	return helper(root.left, min, root.val) && helper(root.right, root.val, max);
}

// Inorder Tranversal
public boolean isValidBST(TreeNode root) {

	WrapperInt lastNode = new WrapperInt();
	lastNode.val = Integer.MIN_VALUE;

	return checkBST(root, lastNode);
}

boolean checkBST(TreeNode root, WrapperInt lastNode) {

	if (root == null) return true;

	if (!checkBST(root, lastNode)) return false;

	if (root.val <= lastNode.val) return false;

	lastNode.val = root.val;

	return checkBST(root, lastNode);
}

class WrapperInt {

	int val;
}