class Solution {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit);
    }

    private TreeNode dfs(TreeNode node, int limit) {

        if (node == null)
            return null;

        if (node.left == null && node.right == null) {
            return node.val >= limit ? node : null;
        }

        node.left = dfs(node.left, limit - node.val);
        node.right = dfs(node.right, limit - node.val);

        if (node.left == null && node.right == null)
            return null;

        return node;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna