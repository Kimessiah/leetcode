// Time O(n)
public String minWindow(String s, String t) {

	if (s == null || s.length() == 0) return "";
	if (t == null || t.length() == 0) return "";
	if (s.length() < t.length()) return "";

	Map<Character, Integer> target = new HashMap<Character, Integer>();
	for (int i = 0; i < t.length(); i++) {
		char c = t.charAt(i);
		if (target.containsKey(c)) {
			target.put(c, target.get(c)+1);
		} else {
			target.put(c, 1);
		}
	}

	int start = 0;
	int minLen = s.length()+1;  // Case: s.length() == t.length()
	int count = 0;
	String res = "";

	Map<Character, Integer> source = new HashMap<Character, Integer>();

	for (int end = 0; end < s.length(); end++) {

		char c = s.charAt(end);
		if (target.containsKey(c)) {
			if (source.containsKey(c)) {
				if (source.get(c) < target.get(c)) {
					count++;
				}
				source.put(c, source.get(c)+1);
			} else {
				source.put(c, 1);
				count++;
			}
		}

		if (count == t.length()) {
			char sc = s.charAt(start);
			while (!source.containsKey(sc) || source.get(sc) > target.get(sc)) {
				if (source.containsKey(sc) && source.get(sc) > target.get(sc)) {
					source.put(sc, source.get(sc)-1);
				}
				start++;
				sc = s.charAt(start);
			}

			if (end-start+1 < minLen) {
				minLen = end-start+1;
				res = s.substring(start, end+1);
			}
		}
	}
	return res;
}