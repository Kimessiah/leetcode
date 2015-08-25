class TrieNode {

	char val;
	boolean isEnd;
	TrieNode[] children;

	public TrieNode() {
		isEnd = false;
		children = new TrieNode[26];
	}

	public TrieNode(char c) {
		val = c;
		isEnd = false;
		children = new TrieNode[26];
	}
}

class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode[] children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (children[c - 'a'] != null) {
				t = children[c - 'a'];
				children = t.children;
			} else {
				t = new TrieNode(c);
				children[c - 'a'] = t;
				children = t.children;
			}

			if (i == word.length() - 1) {
				t.isEnd = true;
			}
		}
	}

	public boolean search(String word) {

		TrieNode[] children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children[c - 'a'] == null) {
				return false;
			} 

			if (i == word.length() - 1 && children[c - 'a'].isEnd) {
				return true;
			}
			children = children[c - 'a'].children;
		}
		return false;
	}

	public boolean startWith(String prefix) {

		TrieNode[] children = root.children;

		for (char c : prefix.toCharArray()) {
			if (children[c - 'a'] == null) {
				return false;
			} 
			children = children[c - 'a'].children;
		}
		return true;
	}
}

public List<String> findWords(char[][] board, String[] words) {

	Set<String> res = new HashSet<>();
    Trie dict = new Trie();
    
    if (board == null || board.length == 0) return new ArrayList<>();
    if (board[0] == null || board[0].length == 0) return new ArrayList<String>();

	for (String word : words) {
		dict.insert(word);
	}

	int m = board.length;
	int n = board[0].length;

	boolean[][] visited = new boolean[m][n];

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			dfs(res, board, visited, "", i, j, dict);
		}
	}
	return new ArrayList<>(res);
}

void dfs(List<String> res, char[][] board, boolean[][] visited, String s, int i, int j, Trie dict) {

	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
		return;
	}

	s = s + board[i][j];

	if (!dict.startWith(s)) return;

	if (dict.search(s)) {
		res.add(s);
	}

	visited[i][j] = true;
	dfs(res, board, visited, s, i-1, j, dict);
	dfs(res, board, visited, s, i+1, j, dict);
	dfs(res, board, visited, s, i, j-1, dict);
	dfs(res, board, visited, s, i, j+1, dict);
	visited[i][j] = false;
}