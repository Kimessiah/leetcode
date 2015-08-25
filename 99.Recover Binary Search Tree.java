// Time O(n)   Space O(logn)
TreeNode prev = null;
TreeNode first = null;
TreeNode second = null;

public void recoverTree(TreeNode root) {

	inorder(root);

    if (first != null && second != null) {
    	int temp = first.val;
    	first.val = second.val;
    	second.val = temp;
    }
}

void inorder(TreeNode root) {

	if (root == null) return;

	inorder(root.left);

	if (prev == null) {
		prev = root; 
	} else {
		if (prev.val > root.val) {
			if (first == null) {
				first = prev;
				second = root;
			} else {
				second = root;
			}
		}
		prev = root;
	}
	inorder(root.right);
}