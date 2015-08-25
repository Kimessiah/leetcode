public List<String> wordBreak(String s, Set<String> wordDict) {

	List<String> res = new ArrayList<>();

	if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
		return res;
	}

	helper(res, "", 0, s, wordDict);

	return res;        
}

void helper(List<String> res, String curr, int start, String s, Set<String> wordDict) {

	if (start == s.length()) {
		res.add(curr);
		return;
	}

	for (int i = start; i < s.length(); i++) {
		String substr = s.substring(start, i+1);
		if (wordDict.contains(substr)) {
			helper(res, curr.length() > 0 ? (curr + " " + substr) : substr, 
				i+1, s, wordDict);
		}
	}
}

public List<String> wordBreak(String s, Set<String> dict) {
    Map<String, List<String>> map = new HashMap<>();
    return wordBreakHelper(s,dict,map);
}

public List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> map){
    if(map.containsKey(s)) return map.get(s);

    List<String> result = new ArrayList<>();

    if(s.length() <= 0) return result;

    for(int len = 1; len <= s.length(); len++){

        String prefix = s.substring(0, len);

        if(dict.contains(prefix)) {
            if(len == s.length()) {
                result.add(prefix);
            } else {
                String suffix = s.substring(len);
                List<String> tmp = wordBreakHelper(suffix, dict, map);
                for (String item : tmp) {
                    result.add(prefix + " " + item);
                }
            }
        }
    }
    map.put(s, result);
    return result;
}