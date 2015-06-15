/**
 * Corner Cases:
 * 1. "-", "+"
 * 2. whitespace
 * 3. overflow issue
**/

public int myAtoi(String str) {

	if (str==null || str.length()==0) {
		return 0;
	}

	int sign = 1;
	long res = 0;
	int i = 0;

	while(i < str.length() && Character.isWhitespace(str.charAt(i))) {
		i++;
	}

	if (i == str.length()) return 0;

	if (str.charAt(i) == '+') {
		i++;
	} else if (str.charAt(i) == '-') {
		sign = -1;
		i++;
	}

	while(i < str.length() && Character.isDigit(str.charAt(i))) {

		res = res * 10 + Character.getNumericValue(str.charAt(i));

		if (res > Integer.MAX_VALUE) {
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		i++;
	}

	return (int) (sign*res);
}