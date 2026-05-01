class Solution {
     int maxSum = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private Info dfs(TreeNode node) {

        if (node == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        if (left.isBST && right.isBST &&
            node.val > left.max &&
            node.val < right.min) {

            int currSum = left.sum + right.sum + node.val;

            maxSum = Math.max(maxSum, currSum);

            int currMin = Math.min(node.val, left.min);
            int currMax = Math.max(node.val, right.max);

            return new Info(true, currMin, currMax, currSum);
        }
        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}