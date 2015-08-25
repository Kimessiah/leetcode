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

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            TrieNode node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.children; 

            if (i == word.length() - 1) {
                node.isEnd = true;
            }
        }        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        TrieNode t = searchNode(word);

        if (t != null && t.isEnd == true) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        if (searchNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode searchNode(String s) {

        Map<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.children;
            } else {
                return null;
            }
        }
        return node;
    }
}