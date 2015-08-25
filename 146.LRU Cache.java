public class LRUCache {
    
	private class Node {

		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}

	private int capacity;
	private Map<Integer, Node> map;
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	map = new HashMap<>();
    	head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

    	if (!map.containsKey(key)) return -1;

    	Node curr = map.get(key);
    	curr.prev.next = curr.next;
    	curr.next.prev = curr.prev;

    	moveToTail(curr);

    	return map.get(key).value;        
    }
    
    public void set(int key, int value) {

    	if (get(key) != -1) {
    		map.get(key).value = value;
    		return;
    	}

    	if (map.size() == capacity) {
    		map.remove(head.next.key);
    		head.next = head.next.next;
    		head.next.prev = head;
    	} 

    	Node item = new Node(key, value);
    	map.put(key, item);
    	moveToTail(item);       
    }

    private void moveToTail(Node node) {
    	node.prev = tail.prev;
    	tail.prev = node;
    	node.prev.next = node;
    	node.next = tail;
    }
}