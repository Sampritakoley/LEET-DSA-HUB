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
    public int rob(TreeNode root) {
        int[] result=dfs(root);
        return Math.max(result[0],result[1]);
    }
    public int[] dfs(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        int[] curr=new int[2];
        curr[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        curr[1]=node.val+left[0]+right[0];
        return curr;
    }
}