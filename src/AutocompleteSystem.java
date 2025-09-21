import java.util.*;


public class AutocompleteSystem {
    private Trie trie;

    // Initialize system with a list of words
    public AutocompleteSystem(List<String> words) {
        trie = new Trie();
        for (String w : words) {
            trie.insert(w.toLowerCase()); // lowercase for consistency
        }
    }

    // Return all words matching the given prefix
    public List<String> getSuggestions(String prefix) {
        prefix = prefix.toLowerCase();
        TrieNode node = trie.findNode(prefix);
        if (node == null) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        dfs(node, new StringBuilder(prefix), result); // collect words recursively
        Collections.sort(result); // lexicographical order (Not necessary)
        return result;
    }

    // DFS helper method: traverse trie and collect words
    private void dfs(TrieNode node, StringBuilder path, List<String> result) {
        if (node.isWord) {
            result.add(path.toString()); // add complete word
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            path.append(entry.getKey()); // add current char
            dfs(entry.getValue(), path, result); // recurse
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}
