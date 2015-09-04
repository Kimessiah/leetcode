public int shortestDistance(String[] words, String word1, String word2) {

	int res = words.length-1;
	int index1 = -1;
	int index2 = -1;

	for (int i = 0; i < words.length; i++) {
		if (words[i].equals(word1)) {
			index1 = i;
			if (index2 >= 0) res = Math.min(res, i - index2);
		} else if (words[i].equals(word2)) {
			index2 = i;
			if (index1 >= 0) res = Math.min(res, i - index1);
		}
	}       
	return res;
}