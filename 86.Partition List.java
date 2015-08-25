public ListNode partition(ListNode head, int x) {

	if (head == null || head.next == null) return head;

	ListNode beforeStart = null;
	ListNode beforeEnd = null;
	ListNode afterStart = null;
	ListNode afterEnd = null;

	while (head != null) {

		if (head.val < x) {
			if (beforeStart == null) {
				beforeStart = head;
				beforeEnd = head;
			} else {
				beforeEnd.next = head;
				beforeEnd = head;
			}
		} else {
			if (afterStart == null) {
				afterStart = head;
				afterEnd = head;
			} else {
				afterEnd.next = head;
				afterEnd = head;
			}
		}
		head = head.next;
	}

	if (beforeStart == null) return afterStart;

	beforeEnd.next = afterStart;

	// Don't forget this step
	if(afterEnd != null) {     
		afterEnd.next = null;
	}
	return beforeStart;
}