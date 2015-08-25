// Time O(min(26^L, size(dict)))   Space O(min(26^L, size(dict)))
public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

	if (beginWord == null || endWord == null || beginWord.length() == 0 
		|| endWord.length() == 0 || beginWord.length() != endWord.length()) {
		return 0;
	}

	int currNum = 1;
	int nextNum = 0;
	int level = 1;

	Queue<String> queue = new LinkedList<String>();
	Set<String> visited = new HashSet<String>();
	queue.add(beginWord);

	while (!queue.isEmpty()) {

		String s = queue.poll();
		currNum--;

		for (int i = 0; i < s.length(); i++) {
			char[] charArr = s.toCharArray();

			for (char c = 'a'; c <= 'z'; c++) {
				charArr[i] = c;
				String temp = new String(charArr);
				if (temp.equals(endWord)) return level + 1;

				if (wordDict.contains(temp) && !visited.contains(temp)) {
					nextNum++;
					visited.add(temp);
					queue.add(temp);
				}
			}
		}
		if (currNum == 0) {
			currNum = nextNum;
			nextNum = 0;
			level++;
		}
	}
	return 0;
}