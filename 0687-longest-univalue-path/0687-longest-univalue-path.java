class Solution {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {

        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if (root.left != null && root.left.val == root.val)
            leftPath = left + 1;

        if (root.right != null && root.right.val == root.val)
            rightPath = right + 1;

        ans = Math.max(ans, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna