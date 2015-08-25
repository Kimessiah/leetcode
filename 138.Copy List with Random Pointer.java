// Time O(n)   Space O(n)
public RandomListNode copyRandomList(RandomListNode head) {

	if (head == null) return null;

	Map<RandomListNode, RandomListNode> map = new HashMap<>();

	RandomListNode p = head;
	RandomListNode dummy = new RandomListNode(0);
	RandomListNode q = dummy;

	while (p != null) {
		RandomListNode copy = new RandomListNode(p.label);
		map.put(p, copy);
		q.next = copy;
		p = p.next;
		q = q.next;
	}

	q = dummy;
	p = head;
	while (p != null) {
		q.next.random = map.get(p.random);
		q = q.next;
		p = p.next;
	}
    return dummy.next;
}

// Time O(n)   Space O(1)
// 1) Create a copy of each of the original node and insert them in between two original nodes in an alternate fashion.
// 2) Assign random pointer of each node copy.
// 3) Restore the input to its original configuration.
public RandomListNode copyRandomList(RandomListNode head) {

	if (head == null) return null;

	RandomListNode p = head;

	// Step 1
	while (p != null) {
		RandomListNode copy = new RandomListNode(p.label);
		copy.next = p.next;
		p.next = copy;
		p = copy.next;
	}

	// Step 2
	p = head;
	while (p != null) {
		p.next.random = (p.random != null) ? p.random.next : null;
		p = p.next.next;
	}

	// Step 3
	p = head;
	RandomListNode headCopy = p.next;
	RandomListNode q = headCopy;
	while (p != null) {
		p.next = q.next;
		q.next = (p.next != null) ? p.next.next : null;
		p = p.next;
		q = q.next;
	}
	return headCopy;
}