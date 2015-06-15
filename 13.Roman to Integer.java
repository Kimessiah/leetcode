Map<Character, Integer> map = new HashMap<>() {{
	put('I', 1); put('V', 5); put('X', 10);
	put('L', 50); put('C', 100); put('D', 500);
	put('M', 1000);
}};

public int romanToInt(String s) {
	int num = 0;
	int prev = 0;
	for (int i=0; i<s.length(); i++) {
		int curr = map.get(s.charAt(i));
		num += prev < curr ? (curr - 2 * prev) : curr;  
		prev = curr;
	}
	return num;
}