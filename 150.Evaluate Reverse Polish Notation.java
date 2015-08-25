private static final Set<String> OPERATORS = 
	new HashSet<>(Arrays.asList("+", "-", "*", "/"));

public int evalRPN(String[] tokens) {

	if (tokens == null || tokens.length == 0) return 0;

	LinkedList<Integer> stack = new LinkedList<>();

	for (String token : tokens) {
		if (OPERATORS.contains(token)) {
			int x = stack.pop();
			int y = stack.pop();
			stack.push(eval(x, y, token));
		} else {
			stack.push(Integer.parseInt(token));
		}
	}
	return stack.pop();
}

private int eval(int x, int y, String operator) {

	switch (operator) {
		case "+" : return x + y;
		case "-" : return y - x;
		case "*" : return x * y;
		default : return y / x;
	}
}

// Using interface, more clean
interface Operator {
	int eval(int x, int y);
}

private static final Map<String, Operator> OPERATORS =
	new HashMap<String, Operator>() {{
    	put("+", new Operator() {
           public int eval(int x, int y) { return x + y; }
        });

        put("-", new Operator() {
           public int eval(int x, int y) { return x - y; }
        });

        put("*", new Operator() {
           public int eval(int x, int y) { return x * y; }
        });

        put("/", new Operator() {
           public int eval(int x, int y) { return x / y; }
        });
}};

public int evalRPN(String[] tokens) {
	Stack<Integer> stack = new Stack<>();
		
	for (String token : tokens) {
	  	if (OPERATORS.containsKey(token)) {
	   		int y = stack.pop();
	     	int x = stack.pop();
	     	stack.push(OPERATORS.get(token).eval(x, y));
	  	} else {
	     stack.push(Integer.parseInt(token));
		} 
	}
	return stack.pop();
}