class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        int sum = 0;      
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

        int delta = val - current.value;

        current.value = val;
        current = root;
        current.sum += delta;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';

            current = current.children[index];
            current.sum += delta;
        }
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

        return current.sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna