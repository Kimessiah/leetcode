// Time O(n)
public boolean isNumber(String s) {

	if (s == null || s.length() == 0) return false;

	s = s.trim();
	int start = 0;

	if (s.charAt(0) == '+' || s.charAt(0) == '-') {
		start++;
	}

	//starting at 'start', each of e/E, dot, and +/- can occur at most once
    int eIndex = -1, dotIndex = -1, signIndex = -1;

	for (int i = start; i < s.length(); i++) {
		char c = s.charAt(i);
		if ((c=='e' || c=='E') && eIndex == -1) {
			eIndex = i;
		} else if (c == '.' && dotIndex == -1) {
			dotIndex = i;
		} else if ((c=='+' || c=='-') && signIndex == -1) {
			signIndex = i;
		} else if (!Character.isDigit(c)) {
			return false;
		}
	}

    //check the positons of e/E, dot, and +/-
    //Specifically, dot must be in the front of e/E, and e/E must be in the RIGHT front of +/-
    //+/- must have a following digit; e/E cannot be in the first and last position;
    //dot is not the unique char of string, and if dot is the first char, the next char cannot be e/E.
    if (signIndex != -1) { //found +/-
        if(eIndex==-1 || signIndex!=eIndex+1 || signIndex==s.length()-1 || !Character.isDigit(s.charAt(signIndex+1))) {
            return false;
        }
    }

    if (eIndex != -1) { //found e
        if(eIndex==start || eIndex==s.length()-1 || eIndex<dotIndex) {
            return false;
        }
    }

    if (dotIndex != -1) { //found dot
        if(dotIndex==start && (dotIndex==s.length()-1 || (eIndex!=-1&& dotIndex==eIndex-1)) {
            return false;
        }
    }

	return true;
}