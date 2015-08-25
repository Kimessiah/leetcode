class TrieNode {

    char val;
    boolean isEnd;
    Map<Character, TrieNode> children;

    // Initialize your data structure here.
    public TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }

    public TrieNode(char c) {
        val = c;
        isEnd = false;
        children = new HashMap<>();
    }
}

public class WordDictionary {

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {

        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;

            if (i == word.length() - 1) {
                t.isEnd = true;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root.children, word, 0);
    }

    private boolean dfs(Map<Character, TrieNode> children, String word, int start) {

        if (start == word.length()) {
            if (children.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        char c = word.charAt(start);

        if (children.containsKey(c)) {
            if (start == word.length()-1 && children.get(c).isEnd) {
                return true;
            }

            return dfs(children.get(c), word, start+1);
        } else if (c == '.') {

            for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                if (start == word.length()-1 && child.getValue().isEnd) {
                    return true;
                }

                if (dfs(child.getValue().children, word, start+1)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}