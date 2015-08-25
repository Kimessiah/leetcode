// Time O(m * n)   Space O(m * n)
public boolean isInterleave(String s1, String s2, String s3) {

	if (s1 == null || s2 == null || s3 == null) return false;

	if (s1.length() + s2.length() != s3.length()) return false;

	boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
	res[0][0] = true;

	for (int i = 1; i <= s1.length(); i++) {
		res[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && res[i-1][0];
	}

	for (int j = 1; j <= s2.length(); j++) {
		res[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && res[0][j-1];
	}

	for (int i = 1; i <= s1.length(); i++) {
		for (int j = 1; j <= s2.length(); j++) {

			res[i][j] = res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
			res[i][j] |= res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
		}
	}
	return res[s1.length()][s2.length()];
}

// Space O(min(m, n))
public boolean isInterleave(String s1, String s2, String s3) {  

	if (s1 == null || s2 == null || s3 == null) return false;

    if(s1.length() + s2.length() != s3.length()) return false;  

    String minWord = s1.length() > s2.length() ? s2 : s1;  
    String maxWord = s1.length() > s2.length() ? s1 : s2;  

    boolean[] res = new boolean[minWord.length()+1];  
    res[0] = true;  

    for(int i = 1; i <= minWord.length(); i++) {  
        res[i] = res[i-1] && minWord.charAt(i-1) == s3.charAt(i-1);  
    }  

    for(int i = 1; i <= maxWord.length(); i++) {  
        res[1] = res[1] && maxWord.charAt(i-1) == s3.charAt(i-1);  

        for(int j=1; j <= minWord.length(); j++) {  
            res[j] = res[j] && maxWord.charAt(i-1) == s3.charAt(i+j-1) 
            	|| res[j-1] && minWord.charAt(j-1) == s3.charAt(i+j-1);  
        }  
    }  
    return res[minWord.length()];  
}  