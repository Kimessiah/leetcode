public String fractionToDecimal(int numerator, int denominator) {

    if (numerator == 0) return "0";
	if (denominator == 0) return "";

	StringBuilder fraction = new StringBuilder();

	if ((numerator < 0) ^ (denominator < 0)) {
		fraction.append("-");
	}

	long num = numerator;
	long den = denominator;
	num = Math.abs(num);
    den = Math.abs(den);
	long quotient = (num / den);
	fraction.append(quotient);

	long reminder = (num % den) * 10;

	if (reminder != 0) fraction.append(".");

	Map<Long, Integer> map = new HashMap<>();

	while (reminder != 0) {
		if (map.containsKey(reminder)) {
			int len = map.get(reminder);
			String result = fraction.substring(0, len);
			result += "(" + fraction.substring(len, fraction.length()) + ")";
			return result;
		}

		quotient = reminder / den;
		map.put(reminder, fraction.length());
		fraction.append(quotient);
		reminder = (reminder % den) * 10;
	}
	return fraction.toString();
}