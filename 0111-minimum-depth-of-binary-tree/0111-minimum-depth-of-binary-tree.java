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
    public int minDepth(TreeNode root) {
        return findDepthMin(root);
    }
    public int findDepthMin(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=findDepthMin(node.left);
        int right=findDepthMin(node.right);
        if(left==0){
            return right+1;
        }else if(right==0){
            return left+1;
        }else{
            return Math.min(left,right)+1;
        }
    }
}