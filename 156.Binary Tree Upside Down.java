// Top-down
public TreeNode upsideDownBinaryTree(TreeNode root) {
    
	TreeNode curr = root;
	TreeNode parent = null;
	TreeNode sibling = null;

	while (curr != null) {
		TreeNode leftChild = curr.left;
		TreeNode rightChild = curr.right;

		curr.left = sibling;
		curr.right = parent;

		parent = curr;
		sibling = rightChild;
		curr = leftChild;
	}
	return parent;
}

// Bottom-up
public TreeNode upsideDownBinaryTree(TreeNode root) {
   return dfsBottomUp(root, null);
}

private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
   if (p == null) return parent;

   TreeNode root = dfsBottomUp(p.left, p);

   p.left = (parent == null) ? parent : parent.right;
   p.right = parent;

   return root;
}