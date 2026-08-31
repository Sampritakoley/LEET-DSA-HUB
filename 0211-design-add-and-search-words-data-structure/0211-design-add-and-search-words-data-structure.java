class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);
        if (ch != '.') {

            int childIndex = ch - 'a';

            TrieNode child = node.children[childIndex];
            if (child == null) {
                return false;
            }

            return dfs(child, word, index + 1);
        }

        for (int i = 0; i < 26; i++) {

            TrieNode child = node.children[i];

            if (child != null) {
                if (dfs(child, word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna