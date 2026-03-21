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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int res=findDiameter(root);
        return diameter;    
    }public int findDiameter(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=findDiameter(node.left);
        int right=findDiameter(node.right);
        diameter=Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }
}