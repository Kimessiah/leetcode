// Time O(n)  Space O(n)
public int longestValidParentheses(String s) {
	if (s == null || s.length() < 2) return 0;

	// d[i]: Length of LVP start at index i
	int[] d = new int[s.length()];
	d[s.length() - 1] = 0;
	int maxLen = 0;

	for (int i = s.length()-2; i >= 0; i--) {
		if (s.charAt(i) == ')') {
			d[i] = 0;
		} else {
			int j = i + d[i+1] + 1;
			if (j < s.length() && s.charAt(j) == ')') {
				d[i] = 2 + d[i+1];
				if (j+1 < s.length()) {
					d[i] += d[j+1];
				}
			}
		}
		maxLen = Math.max(maxLen, d[i]);
	}
	return maxLen;
}

/** Using Stack:
  * 1. Stack stores index of unpaired '('
  *	2. Push when s.charAt(i) == '('
  * 3. When s.charAt(i) == ')', it means there is a potential match
  * 4. If it is a match, update maxLen
**/
public int longestValidParentheses(String s) {
	int maxLen = 0;
    Stack<Integer> stack = new Stack<Integer>();
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == ')' && !stack.isEmpty() && arr[stack.peek()] == '(') {
            stack.pop();
            if (stack.isEmpty())
                maxLen = i + 1;
            else
                maxLen = Math.max(maxLen, i - stack.peek());
        } else {
            stack.push(i);
        }
    }
    return maxLen;
}