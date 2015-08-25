private int sum = 0;

public int sumNumbers(TreeNode root) {

	helper(root, 0);
	return sum;
}

void helper(TreeNode root, int num) {
    
    if (root == null) return;

	if (root.left == null && root.right == null) {
		sum += num * 10 + root.val;
		return;
	}

	helper(root.left, num*10 + root.val);
	helper(root.right, num*10 + root.val);
}