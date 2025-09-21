import java.util.*;

// Trie data structure for storing words
public class Trie {
    private TrieNode root = new TrieNode();

    public TrieNode getRoot() {
        return root;
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        cur.isWord = true; // mark end of word
    }

    // Return node corresponding to last character of prefix, or null if prefix not found
    public TrieNode findNode(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            cur = cur.children.get(ch);
            if (cur == null){
                return null;
            }
        }
        return cur;
    }
}
