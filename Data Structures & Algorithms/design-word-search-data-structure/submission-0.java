class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.children[c - 'a'] = newNode;
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int index, TrieNode curr) {
        if(index == word.length()) {
            return curr.isEnd;
        }

        char c = word.charAt(index);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                TrieNode child = curr.children[i];
                if(child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode node = curr.children[c - 'a'];
            if(node == null) {
                return false;
            }
            return search(word, index + 1, node);
        }
    }
}
public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}