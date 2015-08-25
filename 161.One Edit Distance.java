// Time O(n)   Space O(1)
public boolean isOneEditDistance(String s, String t) {
	
	if (s == null || t == null) return false;

	int m = s.length();
	int n = t.length();

	if (m > n) return isOneEditDistance(t, s);

	if (n - m > 1) return false;

	int i = 0;
	int shift = n - m;

	while (i < m && s.charAt(i) == t.charAt(i)) i++;

	if (i == m) return shift > 0;
	if (shift == 0) i++;

	while (i < m && s.charAt(i) == t.charAt(i+shift)) i++;

	return i == m;
}