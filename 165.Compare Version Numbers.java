public int compareVersion(String version1, String version2) {

    if (version1 == null || version1.length() == 0) return 0;
	if (version2 == null || version2.length() == 0) return 0;

	int i = 0;
	int j = 0;

	while (i < version1.length() || j < version2.length()) {
        long v1 = 0;
        long v2 = 0;
        
        while (i < version1.length() && version1.charAt(i) != '.') {
            v1 = 10 * v1 + (version1.charAt(i) - '0');
            i++;
        }
        i++;
        
        while (j < version2.length() && version2.charAt(j) != '.') {
            v2 = 10 * v2 + (version2.charAt(j) - '0');
            j++;
        }
        j++;
        
        if (v1 > v2) return 1;
        if (v1 < v2) return -1;
	}
    return 0;
}