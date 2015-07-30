// Time O(n)
public ListNode rotateRight(ListNode head, int k) {

	if (head == null || k <= 0) return head;

	int i = 0; 
	k = k % getLength(head);

	ListNode dummy = new ListNode(0);
	dummy.next = head;

	ListNode runner = dummy;
	ListNode walker = dummy;


	while (runner != null && i < k) {
		runner = runner.next;
		i++;
	}

	while (runner.next != null) {
		runner = runner.next;
		walker = walker.next;
	}

	runner.next = dummy.next;
	dummy.next = walker.next;
	walker.next = null;

	return dummy.next;
}

int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
        length ++;
        head = head.next;
    }
    return length;
}