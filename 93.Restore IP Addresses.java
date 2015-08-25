// Time 
public List<String> restoreIpAddresses(String s) {

	List<String> res = new ArrayList<String>();

	if (s == null || s.length() == 0) return res;

	helper(res, "", 0, s, 1);
	return res;
}

void helper(List<String> res, String ipAddress, int index, String s, int segment) {

	if (index >= s.length()) return;

	if (segment == 4) {
		String str = s.substring(index);
		if (isValid(str)) {
			res.add(ipAddress + "." + str)
		}
		return;
	}

	for (int i = 1; i < 4 && (index+i <= s.length()); i++) {

		String str = s.substring(index, index+i);
		if (isValid(str)) {
			if (segment == 1) {
				helper(res, str, index+i, s, segment+1);
			} else {
				helper(res, ipAddress + "." + str, index+i, s, segment+1);
			}
		}
	}
}

boolean isValid(String s) {

	if (s == null || s.length() > 3) return false;

	if (s.charAt(0) == '0' && s.length() > 1) return false;

	int num = Integer.parseInt(s);

	if (num >=0 && num < 256) return true;

	return false;
}