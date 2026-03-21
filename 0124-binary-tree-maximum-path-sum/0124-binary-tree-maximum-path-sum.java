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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res=maxSum(root);
        return maxSum;
    }public int maxSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum=Math.max(0,maxSum(node.left));
        int rightSum=Math.max(0,maxSum(node.right));
        maxSum=Math.max(maxSum,leftSum+rightSum+node.val);
        return Math.max(leftSum,rightSum)+node.val;
    }
}