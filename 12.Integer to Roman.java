static final String[] romans = {
	"M", "CM", "D", "CD",
	"C", "XC", "L", "XL",
	"X", "IX", "V", "IV",
	"I"
};

static final int[] values = {
	1000, 900, 500, 400,
	100, 90, 50, 40, 
	10, 9, 5, 4, 1
};

public String intToRoman(int num) {

	StringBuilder sb = new StringBuilder();
	int i = 0;

	while (num > 0) {
		int n = num / values[i];
		num %= values[i]; 
		for (int k=0; k<n; k++) {
			sb.append(romans[i]);
		}
		i++;
	}
	return sb.toString();
}