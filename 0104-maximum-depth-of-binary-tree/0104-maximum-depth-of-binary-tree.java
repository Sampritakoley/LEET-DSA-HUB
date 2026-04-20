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
    public int maxDepth(TreeNode root) {
        
        int maxDepth=findDepth(root);
        return maxDepth;
    }public int findDepth(TreeNode node){
        if(node==null){
            return 0;
        }

        int left=findDepth(node.left);
        int right=findDepth(node.right);
        return Math.max(left,right)+1;
    }
}