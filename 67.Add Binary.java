public String addBinary(String a, String b) {

	if(a == null || a.length() == 0)
        return b;

    if(b == null || b.length() == 0)
        return a;

	a = new StringBuilder(a).reverse().toString();
	b = new StringBuilder(b).reverse().toString();

	int i = 0;
	int j = 0;
	int carry = 0;

	StringBuilder res = new StringBuilder();

	while (i < a.length() && j < b.length()) {
		int sum = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carry;
		carry = sum / 2;
		res.append(sum % 2);
		i++;
		j++;
	}

	if (i == a.length()) {
		while (j < b.length()) {
			int sum = (b.charAt(j)-'0') + carry;
			carry = sum / 2;
			res.append(sum % 2);
			j++;
		}
	}

	if (j == b.length()) {
		while (i < a.length()) {
			int sum = (a.charAt(i)-'0') + carry;
			carry = sum / 2;
			res.append(sum % 2);
			i++;
		}
	}

	if (carry > 0) res.append(carry);

	return res.reverse().toString();	
}