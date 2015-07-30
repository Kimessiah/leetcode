public ListNode removeNthFromEnd(ListNode head, int n) {

	if (head == null) return null;

	ListNode slow = head;
	ListNode fast = head;
	ListNode prev = null;

	int i = 0;
	while (fast != null && i < n) {
		fast = fast.next;
		i++;
	}

	if (fast == null && i == n) return head.next;  // Need to remove first element of linked list

	while (fast != null) {
		prev = slow;
		slow = slow.next;
		fast = fast.next;
	}

	if (prev != null) {
		prev.next = slow.next;
	}
	return head;
}