class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(findRoot(word));
        }

        return result.toString();
    }

    private void insert(String word) {

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

    private String findRoot(String word) {

        TrieNode current = root;

        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';
            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];
            prefix.append(ch);
            if (current.isEnd) {
                return prefix.toString();
            }
        }
        return word;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna