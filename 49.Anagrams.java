// Note: All groups of strings
// Time O(nklogk)   Space O(nk)
public List<String> anagrams(String[] strs) {

	List<String> res = new ArrayList<String>();
	if (strs == null || strs.length == 0) return res;

	Map<String, List<String>> map = new HashMap<String, List<String>>();

	for (int i = 0; i< strs.length; i++) {
		char[] c = strs[i].toCharArray();
		Arrays.sort(c);
		String str = String.valueOf(c);

		if (map.containsKey(str)) {
			List<String> list = map.get(str);
			list.add(strs[i]);

		} else {
			List<String> list = new ArrayList<String>();
			list.add(strs[i]);
			map.put(str, list);
		}
	}

	Iterator iter = map.values().iterator();
	while (iter.hasNext()) {
		List<String> list = (List<String>) iter.next();
		if (list.size() > 1) {
			res.addAll(list);
		}
	}

	return res;
}