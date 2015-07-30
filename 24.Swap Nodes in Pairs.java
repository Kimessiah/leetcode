// O(n)
public swapPairs(ListNode head){
	if (head == null || head.next == null) return head;

	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy;
	ListNode curr = head;

	while (curr != null && curr.next != null) {  // !!! For NPE
	    ListNode post = curr.next;
		prev.next = post;
		curr.next = post.next;
		post.next = curr;
		prev = curr;
		curr = curr.next;
	}
	return dummy.next;
}