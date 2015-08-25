public List<TreeNode> generateTrees(int n) {

	return helper(1, n);
}

List<TreeNode> helper(int left, int right) {

	List<TreeNode> res = new ArrayList<TreeNode>();

	if (left > right) {
		res.add(null);
		return res;
	}

	for (int i = left; i <= right; i++) {

		List<TreeNode> leftTree = helper(left, i-1);
		List<TreeNode> rightTree = helper(i+1, right);

		for (int j = 0; j < leftTree.size(); j++) {
			for (int k = 0; k < rightTree.size(); k++) {

				TreeNode root = new TreeNode(i);
				root.left = leftTree.get(j);
				root.right = rightTree.get(k);
				res.add(root);
			}
		}
	}
	return res;
}