/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val=dfs(root);
        return max;
    }private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=Math.max(0,dfs(root.left));
        int rightSum=Math.max(0,dfs(root.right));
        int currentPathSum=root.val+leftSum+rightSum;
        max=Math.max(max,currentPathSum);
        return Math.max(leftSum,rightSum)+root.val;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna