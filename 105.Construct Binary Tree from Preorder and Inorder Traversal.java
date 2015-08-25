public TreeNode buildTree(int[] preorder, int[] inorder) {

	if (preorder == null || inorder == null) return null;

	return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
}

TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {

	if (pStart > pEnd || iStart > iEnd) return null;


	TreeNode root = new TreeNode(preorder[pStart]);

	int index = iStart;
	for (int i = iStart; i <=iEnd; i++) {
		if (inorder[i] == preorder[pStart]) {
			index = i;
			break;
		}
	}

	root.left = helper(preorder, pStart+1, pStart+index-iStart, inorder, iStart, index-1);
	root.right = helper(preorder, pStart+index-iStart+1, pEnd, inorder, index+1, iEnd);

	return root;
}