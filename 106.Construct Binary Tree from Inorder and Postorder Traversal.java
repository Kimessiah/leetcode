public TreeNode buildTree(int[] inorder, int[] postorder) {

	if (inorder == null || postorder == null) return null;

	return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
}

TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {

	if (iStart > iEnd || pStart > pEnd) return null;

	TreeNode root = new TreeNode(postorder[pEnd]);

	int index = iStart;
	while (index <= iEnd) {
		if (inorder[index] == postorder[pEnd]) {
			break;
		}
		index++;
	}

	root.left = helper(inorder, iStart, index-1, postorder, pStart, pStart+index-iStart-1);
	root.right = helper(inorder, index+1, iEnd, postorder, pStart+index-iStart, pEnd-1);
	return root;
}