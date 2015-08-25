// Time O(n)   Space O(1)
public void reorderList(ListNode head) {

	if (head == null || head.next == null) return;

	ListNode slow = head;
	ListNode fast = head;

	while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}

	ListNode after = slow.next;
	slow.next = null;
	after = reverse(after);
	ListNode before = head;

	while (before != null && after != null) {
		ListNode beforeNext = before.next; 
		ListNode afterNext = after.next;
		before.next = after;
		after.next = beforeNext;
		before = beforeNext;
		after = afterNext;
	}
}

ListNode reverse(ListNode head) {

	if (head == null || head.next == null) return head;

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