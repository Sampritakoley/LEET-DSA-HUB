class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        reverseInorder(root);

        return root;
    }

    private void reverseInorder(TreeNode root) {

        if (root == null) {
            return;
        }
        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna