public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

	if (headA == null || headB == null) return null;

	int lenA = getLength(headA);
	int lenB = getLength(headB);

	if (lenA < lenB) return getIntersectionNode(headB, headA);

	ListNode currA = headA;
	ListNode currB = headB;
	int delta = lenA - lenB;

	while (currA != null && delta > 0) {
		currA = currA.next;
		delta--;
	}

	while (currA != null && currB != null) {
		if (currA == currB) {
			break;
		}
		currA = currA.next;
		currB = currB.next;
	}
	return currA;
}

int getLength(ListNode head) {

	int len = 0;
	while (head != null) {
		head = head.next;
		len++;
	}
	return len;
}