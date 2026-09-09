class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        // Special case: insert new root
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        addRow(root, val, depth, 1);

        return root;
    }

    private void addRow(TreeNode node, int val, int depth, int currentDepth) {

        if (node == null) {
            return;
        }
        if (currentDepth == depth - 1) {

            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;
            node.left = new TreeNode(val);
            node.left.left = oldLeft;

            node.right = new TreeNode(val);
            node.right.right = oldRight;

            return;
        }

        addRow(node.left, val, depth, currentDepth + 1);
        addRow(node.right, val, depth, currentDepth + 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna