public class WordDistance {

	Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {

    	for (int i = 0; i < words.length; i++) {
    		String word = words[i];
    		if (map.containsKey(word)) {
    			map.get(word).add(i);
    		} else {
    			List<Integer> list = new ArrayList<>();
    			list.add(i);
    			map.put(word, list);
    		}
    	}
    }

    public int shortest(String word1, String word2) {

    	List<Integer> list1 = map.get(word1);
    	List<Integer> list2 = map.get(word2);

    	int res = Integer.MAX_VALUE;

    	for (int i : list1) {
    		for (int j : list2) {
    			res = Math.min(Math.abs(i-j), res);
    		}
    	}
        return res;
    }
}