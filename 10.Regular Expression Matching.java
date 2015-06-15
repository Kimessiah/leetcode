/**
  * 1. If the next character of p is NOT ‘*’, then it must match the current character of s. 
  *    Continue pattern matching with the next character of both s and p.
  * 2. If the next character of p is ‘*’, then we do a brute force exhaustive matching of 0, 1, 
  *    or more repeats of current character of p... Until we could not match any more characters. 
**/
public boolean isMatch(String s, String p) {
	helper(s, p, 0, 0);
}

private boolean helper(String s, String p, int i, int j) {
	if (j == p.length()) {
		return i == s.length();
	}

	if (j == p.length()-1 || p.charAt(j+1) != '*') {
		return (i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j))) 
			&& helper(s, p, i+1, j+1);
	}

	while (i<s.length() && (p.charAt(j)=='.') || s.charAt(i)==p.charAt(j)) {
		if (helper(s, p, i, j+2))
			return true;

		i++;
	}
	return helper(s, p, i, j+2);
}


// Dynamic Programming O(n^2)
public boolean isMatch(String s, String p) {

}
