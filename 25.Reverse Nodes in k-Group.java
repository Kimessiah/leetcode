/** Given this linked list: 1->2->3->4->5

  * For k = 2, you should return: 2->1->4->3->5

  * For k = 3, you should return: 3->2->1->4->5
*/

// Iterative O(n)
// Note: Be aware of the case which length(list) == k
// Time O(n)
public ListNode reverseKGroup(ListNode head, int k) {
	if (head == null || k < 2) return head;

	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy;
	ListNode curr = head;

	while (curr != null) {
		ListNode p = curr;
		int count = 1;
		while (curr != null && count < k) {
			curr = curr.next;
			count++;
		}

		if (curr == null) {
			return dummy.next;
		} else {
			ListNode q = curr.next;
			prev.next = reverse(p, curr);
			curr = q;
			prev = p;
			p.next = q;
		}
	}
	return dummy.next;
}

ListNode reverse(ListNode start, ListNode end) {

	ListNode curr = start;
	ListNode prev = null;

	while (curr != end) {
		ListNode q = curr.next;
		curr.next = prev;
		prev = curr;
		curr = q;
	}
	curr.next = prev;
	return curr;
}

// Recursive 