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
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left,root.right);
    }public boolean checkSymmetric(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2== null || n1.val!=n2.val){
            return false;
        }
        return checkSymmetric(n1.left,n2.right) && checkSymmetric(n1.right,n2.left);
    }
}