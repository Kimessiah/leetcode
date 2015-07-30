// Brute Force: Time 2n + 3n + ... + kn = O(nk^2) Space O(1)


// Heap: Time O(nklogk) Space O(k)
static final Comparator<ListNode> listComparator = 
	new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};

public ListNode mergeKLists(ListNode[] lists) {
	if (lists.length == 0) return null;

	Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, listComparator);

	for (ListNode node : lists) {
		if (node != null) {
			queue.add(node);
		}
	}

	ListNode dummy = new ListNode(0);
	ListNode p = dummy;
	while (!queue.isEmpty()) {
		ListNode node = queue.poll();
		p.next = node;
		p = p.next;
		if (node.next != null) {
			queue.add(node.next);
		}
	}
	return dummy.next;
}


// Divide and Conquer: Time O(nklogk) Space O(1)
public ListNode mergeKLists(ListNode[] lists) {

	if (lists.length == 0) return null;
	int end = lists.length - 1;

	while (end > 0) {
		int begin = 0;
		while (begin < end) {
			lists[begin] = merge2Lists(lists[begin], lists[end]);
			begin++;
			end--;
		}
	}
	return lists[0];
}


private ListNode merge2Lists(ListNode l1, ListNode l2) {
   ListNode dummyHead = new ListNode(0);
   ListNode p = dummyHead;
   while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
         p.next = l1;
         l1 = l1.next;
      } else {
         p.next = l2;
         l2 = l2.next;
		}
		p = p.next; 
	}
	if (l1 != null) p.next = l1;
	if (l2 != null) p.next = l2;
	return dummyHead.next;
}