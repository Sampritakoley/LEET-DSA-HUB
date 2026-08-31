class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root;

    private List<String> result = new ArrayList<>();

    private int[][] directions = {
        {-1, 0}, 
        {1, 0},  
        {0, -1},
        {0, 1}   
    };

    public List<String> findWords(char[][] board, String[] words) {

        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                dfs(board, row, col, root);
            }
        }

        return result;
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

        current.word = word;
    }

    private void dfs(
        char[][] board,
        int row,
        int col,
        TrieNode node
    ) {

        if (row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length) {

            return;
        }

        if (board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        int index = ch - 'a';

        if (node.children[index] == null) {
            return;
        }

        TrieNode nextNode = node.children[index];

        if (nextNode.word != null) {

            result.add(nextNode.word);

            nextNode.word = null;
        }

        board[row][col] = '#';

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            dfs(board, newRow, newCol, nextNode);
        }

        board[row][col] = ch;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna