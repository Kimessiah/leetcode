// Time O(n)
public List<String> findRepeatedDnaSequences(String s) {

	List<String> res = new ArrayList<>();

	if (s == null || s.length() < 10) return res;

	Map<Character, Integer> map = new HashMap<>();
	map.put('A', 0);
	map.put('C', 1);
	map.put('G', 2);
	map.put('T', 3);

	Set<Integer> curr = new HashSet<>();
	Set<Integer> added = new HashSet<>();
	int hash = 0;

	for (int i = 0; i < s.length(); i++) {
		hash = (hash << 2) + map.get(s.charAt(i));
		if (i >= 9) {
			hash = hash & (1 << 20) - 1;
			if (curr.contains(hash) && !added.contains(hash)) {
				res.add(s.substring(i - 9, i + 1));
				added.add(hash);
			} else {
				curr.add(hash);
			}
		}
	}
	return res;        
}