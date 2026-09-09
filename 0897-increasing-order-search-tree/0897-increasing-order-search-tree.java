class Solution {

    private TreeNode current;

    public TreeNode increasingBST(TreeNode root) {

        TreeNode dummy = new TreeNode(0);
        current = dummy;

        inorder(root);

        return dummy.right;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        current.right = root;
        root.left = null;
        current = root;

        inorder(root.right);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna