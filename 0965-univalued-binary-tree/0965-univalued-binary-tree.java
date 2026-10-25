
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return check(root, root.val);
    }

    private boolean check(TreeNode node, int value) {
        if (node == null) {
            return true;
        }

        if (node.val != value) {
            return false;
        }

        return check(node.left, value)
            && check(node.right, value);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna