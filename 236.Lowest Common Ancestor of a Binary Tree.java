// Time O(n)
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	if (root == null) return null;
	if (root == p || root == q) return root;

	TreeNode L = lowestCommonAncestor(root.left, p, q);
	TreeNode R = lowestCommonAncestor(root.right, p, q);

	if (L != null && R != null) return root;

	return L != null ? L : R;        
}