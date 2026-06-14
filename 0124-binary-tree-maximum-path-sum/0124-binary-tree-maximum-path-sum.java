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
        MPS(root);
        return max;
    }
    public int MPS(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum=Math.max(MPS(node.left),0);
        int rightSum=Math.max(MPS(node.right),0);
        max=Math.max(max,(leftSum+rightSum+node.val));
        return Math.max(leftSum,rightSum)+node.val;
    }
}