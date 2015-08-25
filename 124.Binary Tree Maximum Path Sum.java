// Time O(n)   Space O(logn)
private int maxSum = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {

	helper(root);
	
	return maxSum;
}

int helper(TreeNode root) {

	if (root == null) return 0;

	int leftSum = helper(root.left);

	int rightSum = helper(root.right);

	int sum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);

	maxSum = Math.max(maxSum, sum);

	return root.val + Math.max(leftSum, Math.max(rightSum, 0));
}