class Solution {

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {

        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left);
        moves += Math.abs(right);

        return node.val + left + right - 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna