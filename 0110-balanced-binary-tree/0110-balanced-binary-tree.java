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
    public boolean isBalanced(TreeNode root) {
        int res=checkBBtree(root);
        if(res==-1){
            return false;
        }
        return true;
    }public int checkBBtree(TreeNode node){
         if(node==null){
            return 0;
         }

         int left=checkBBtree(node.left);
         if(left==-1){
            return -1;
         }
         int right=checkBBtree(node.right);
         if(right==-1){
            return -1;
         }

         if(Math.abs(left-right)>1){
            return -1;
         }

         return Math.max(left,right)+1;
    }
}