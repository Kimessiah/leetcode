// Time O(n)
public ListNode reverseBetween(ListNode head, int m, int n) {

	if (head == null || head.next == null) return head;

	int i = 1;
	ListNode start = head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy;

	while (start != null && i < m) {
		prev = start;
		start = start.next;
		i++;
	}

	if (i < m) return head;

	ListNode curr = start.next;

	while (curr != null && i < n) {
		ListNode post = curr.next;
		curr.next = prev.next;
		prev.next = curr;
		start.next = post;
		curr = post;
		i++;
	}
	return dummy.next;
}