class Solution {

    private int answer = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, root.val, root.val);

        return answer;
    }

    private void dfs(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return;
        }
        answer = Math.max(answer, node.val - minValue);
        answer = Math.max(answer, maxValue - node.val);
        minValue = Math.min(minValue, node.val);
        maxValue = Math.max(maxValue, node.val);

        dfs(node.left, minValue, maxValue);
        dfs(node.right, minValue, maxValue);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna