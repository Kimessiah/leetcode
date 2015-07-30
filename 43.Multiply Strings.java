public String multiply(String num1, String num2) {

	num1 = new StringBuilder(num1).reverse().toString();
	num2 = new StringBuilder(num2).reverse().toString();

	int[] d = new int[num1.length + num2.length];

	for (int i= 0; i< num1.length; i++) {
		for (int j = 0; j < num2.length; j++) {
			d[i + j] += Character.getNumericValue(num1.charAt(i))
						* Character.getNumericValue(num2.charAt(j));
		}
	}

	StringBuilder sb = new StringBuilder();

	for (int i= 0; i< d.length; i++) {
		int carry = d[i] / 10;
		int digit = d[i] % 10;
		sb.insert(0, digit);
		if (i < d.length - 1) {
			d[i+1] += carry;
		}
	}

	while (sb.length() >0 && sb.charAt(0) == '0') {
		sb.deleteCharAt(0);
	}

	return sb.length() == 0 ? "0" : sb.toString();
}