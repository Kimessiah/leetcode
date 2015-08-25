// Time O(n^2)
public ListNode insertionSortList(ListNode head) {

	if (head == null) return null;

	ListNode dummy = new ListNode(0);
	ListNode curr = head;
	ListNode prev = dummy;

	while (curr != null) {

		ListNode next = curr.next;
		prev = dummy;

		while (prev.next != null && prev.next.val <= curr.val) {
			prev = prev.next;
		}

		curr.next = prev.next;
		prev.next = curr;
		curr = next;
	}
	return dummy.next;
}