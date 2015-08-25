public List<List<Integer>> pathSum(TreeNode root, int sum) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (root == null) return res;

	List<Integer> curr = new ArrayList<Integer>();
	curr.add(root.val);

	helper(res, curr, root, sum - root.val);
	return res;
}

void helper(List<List<Integer>> res, List<Integer> curr, TreeNode root, int sum) {

	if (root == null) return;

	if (root.left == null && root.right == null && sum == 0) {
		res.add(new ArrayList<Integer>(curr));
		return;
	}

	if (root.left != null) {
		curr.add(root.left.val);
		helper(res, curr, root.left, sum - root.left.val);
		curr.remove(curr.size()-1);
	}

	if (root.right != null) {
		curr.add(root.right.val);
		helper(res, curr, root.right, sum - root.right.val);
		curr.remove(curr.size()-1);
	}
}