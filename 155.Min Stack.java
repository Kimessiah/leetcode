class MinStack {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
    	s1.push(x);

    	if (s2.isEmpty() || s2.peek() >= x) {
    		s2.push(x);
    	}        
    }

    public void pop() {

    	if (s1.isEmpty()) return;

    	int x = s1.pop();

    	if (x == s2.peek()) {
    		s2.pop();
    	}
    }

    public int top() {
        return s1.isEmpty() ? 0 : s1.peek();
    }

    public int getMin() {
        return s2.isEmpty() ? 0 : s2.peek();
    }
}