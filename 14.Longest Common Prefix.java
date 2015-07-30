// O(L*N)
public String longestCommonPrefix(String[] strs) {

	if (strs.length == 0) return "";

	StringBuilder sb = new StringBuilder();
	String s = strs[0];

	outer:
	for (int i=0; i<s.length(); i++) {
		for (int j=1; j<strs.length; j++) {
			String curr = strs[j];
			if (i >= curr.length() || s.charAt(i) != curr.charAt(i))
				break outer;
		}
		sb.append(s.charAt(i));
	}
	return sb.toString();
}