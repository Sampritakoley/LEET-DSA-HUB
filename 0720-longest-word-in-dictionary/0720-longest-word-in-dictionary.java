class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private String best = "";

    public String longestWord(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {
            insert(root, word);
        }
        dfs(root, new StringBuilder());

        return best;
    }

    private void insert(TrieNode root, String word) {

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

    private void dfs(TrieNode node, StringBuilder currentWord) {
        for (int i = 0; i < 26; i++) {

            TrieNode child = node.children[i];
            if (child == null) {
                continue;
            }
            if (!child.isEnd) {
                continue;
            }
            currentWord.append((char) ('a' + i));
            String current = currentWord.toString();

            if (current.length() > best.length()
                    || (current.length() == best.length()
                        && current.compareTo(best) < 0)) {

                best = current;
            }
            dfs(child, currentWord);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna