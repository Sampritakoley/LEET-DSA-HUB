class Solution {
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        if (minCamera(root) == 0) {
            return ++camera;
        }
        return camera;
    }
    public int minCamera(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if (left == 0 || right == 0) {
            camera++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna