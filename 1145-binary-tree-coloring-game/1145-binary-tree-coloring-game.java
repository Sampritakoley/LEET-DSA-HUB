class Solution {

    int left = 0;
    int right = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        count(root, x);

        int parent = n - left - right - 1;

        int largest = Math.max(parent, Math.max(left, right));

        return largest > n / 2;
    }

    private int count(TreeNode node, int x) {

        if (node == null)
            return 0;

        int l = count(node.left, x);
        int r = count(node.right, x);

        if (node.val == x) {
            left = l;
            right = r;
        }

        return l + r + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna