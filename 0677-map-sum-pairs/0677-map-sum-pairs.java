class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        int value = 0;
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
        current.value = val;
    }

    public int sum(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }
        return dfs(current);
    }

    private int dfs(TrieNode node) {
        int sum = 0;

        if (node.isEnd) {
            sum += node.value;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sum += dfs(node.children[i]);
            }
        }

        return sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna