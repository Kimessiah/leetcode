// Time O(n)
public ListNode deleteDuplicated(ListNode head) {

	if (head == null || head.next == null) return head;

	ListNode prev = head;
	ListNode curr = head.next;

	while (curr != null) {

		if (prev.val == curr.val) {
			prev.next = curr.next;
			curr = curr.next;
		} else {
			prev = curr;
			curr = curr.next;
		}
	}
	return head;
}