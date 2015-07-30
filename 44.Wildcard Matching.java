// Iterative
public boolean isMatch(String s, String p) {

	if (s == null || p == null) return false;

	int i = 0; int j = 0;
	int match = 0;
	int startId = -1;

	while (i < s.length()) {
		if (j < p.length() && (s.charAt(i) == p.charAt(j) 
				|| p.charAt(j) == '?')) {
			i++;
			j++;
		} else if (j < p.length() && p.charAt(j) == '*') {
			startId = j;
			match = i;
			j++;
		} else if (startId != -1) {
			match++;
			i = match;
			j = startId + 1;
		} else {
			return false;
		}
	}

	while (j < p.length() && p.charAt(j) == '*') {
		j++;
	}

	return j == p.length();
}

// Recursive
public boolean isMatch(String s, String p, int i, int j) {  

    if(j == p.length()) return i == s.length();  

    if(p.charAt(j) == '*') {  
		while(j < p.length() && p.charAt(j) == '*') j++;   // Move the index at p to a non-start char.  
        
        while(i < s.length()) {  
            if(isMatch(s, p, i, j)) return true; // Find one match, return true.  
            i++; // Try the next one.  
        } 
        return isMatch(s, p, i, j);  

    } else if(i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
        return isMatch(s, p, i + 1, j + 1);  
    }

    return false;  
}  

// Dynamic Programming: Time O(n*m)  Space O(n*m)
