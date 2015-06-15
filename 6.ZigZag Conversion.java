public String convert(String s, int nRows) {
	if (s== null || s.length()==0 || nRows == 1)
		return s;

	int delta = 2*nRows - 2;
	StringBuilder sb = new StringBuilder();

	for (int i=0; i<nRows; i++) {

		for (int j=i; j<s.length();) {
			sb.append(s.charAt(j));

			if (i!=0 && i!=nRows-1) {
				int d = delta - 2*i;
				if (j+d < s.length()) {
					sb.append(s.charAt(j+d));
				} 

			}
			j += delta;
		}
	}
	return sb.toString();
}