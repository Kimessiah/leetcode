// Bottom-up recursion: Time O(n)   Space O(logn)
private ListNode list;

public TreeNode sortedListToBST(ListNode head) {

	if (head == null) return null;

	int n = 0;
	ListNode p = head;
	while (p != null) {
		p = p.next;
		n++;
	}

	list = head;

	return helper(0, n-1);
}

TreeNode helper(int start, int end) {

	if (start > end) return null;

	int mid = (start + end) / 2;

	TreeNode leftChild = helper(start, mid-1);

	TreeNode parent = new TreeNode(list.val);

	list = list.next;

	TreeNode rightChild = helper(mid+1, end);

	parent.left = leftChild;
	parent.right = rightChild;

	return parent;
}