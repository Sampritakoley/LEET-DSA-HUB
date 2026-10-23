class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {
            return root.left.val
                    + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna