// Two pass: Time O(n)
public void reverseWords(char[] s) {

	if (s == null || s.length == 0) return;

	reverse(s, 0, s.length);
	int i = 0;
	for (int j = 0; j <= s.length; j++) {
		if (j == s.length || s[j] == ' ') {
			reverse(s, i, j);
			i = j + 1;
		}
	}
}

void reverse(char[] s, int start, int end) {
	for (int i = 0; i < (end - start) / 2; i++) {
		char temp = s[start + i];
		s[start + i] = s[end - i - 1];
		s[end - i - 1] = temp;
	}
}