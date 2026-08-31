class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {

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

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna