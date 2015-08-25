// Iterative
public ListNode reverseList(ListNode head) {

	if (head == null || head.next == null) {
		return head;
	}

	ListNode prev = null;
	ListNode curr = head;

	while (curr != null) {
		ListNode post = curr.next;
		curr.next = prev;
		prev = curr;
		curr = post;
	}
	return prev;
 }


// Recursive
public ListNode reverseList(ListNode head) {

	if (head == null || head.next == null) {
		return head;
	}

	ListNode curr = head;
	ListNode reversed = reverseList(head.next);
	curr.next.next = curr;
	curr.next = null;

	return reversed;
}