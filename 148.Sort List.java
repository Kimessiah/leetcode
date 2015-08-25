// Time O(nlogn)
public ListNode sortList(ListNode head) {

	if (head == null || head.next == null) return head;

	ListNode slow = head;
	ListNode fast = head;
	ListNode prev = null;

	while (fast != null && fast.next != null) {
		fast = fast.next.next;
		prev = slow;
		slow = slow.next;
	}

	prev.next = null;
    
	ListNode head1 = sortList(head);
	ListNode head2 = sortList(slow);

    return merge(head1, head2);
}

ListNode merge(ListNode head1, ListNode head2) {

	if (head1 == null) return head2;
	if (head2 == null) return head1;

	ListNode dummy = new ListNode(0);
	ListNode curr = dummy;

	while (head1 != null && head2 != null) {

		if (head1.val < head2.val) {
			curr.next = head1;
			head1 = head1.next;
		} else {
			curr.next = head2;
			head2 = head2.next;
		}
		curr = curr.next;
	}

	if (head1 == null) curr.next = head2;

	if (head2 == null) curr.next = head1;

	return dummy.next;
}
