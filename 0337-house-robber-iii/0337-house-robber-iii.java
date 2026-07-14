class Solution {

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int skip = Math.max(left[0], left[1]) +
                   Math.max(right[0], right[1]);

        int rob = node.val +
                  left[0] +
                  right[0];

        return new int[]{skip, rob};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna