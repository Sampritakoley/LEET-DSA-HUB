class Solution {

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        int left = kthSmallest(root.left, k);

        if (left != -1) {
            return left;
        }

        count++;

        if (count == k) {
            return root.val;
        }

        return kthSmallest(root.right, k);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna