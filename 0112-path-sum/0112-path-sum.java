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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return hasPath(root,targetSum);
    }public boolean hasPath(TreeNode node,int target){
        if(node.left==null && node.right==null && node.val==target){
            return true;
        }
        if(node.left==null && node.right==null && node.val!=target){
            return false;
        }
        boolean left=false;boolean right=false;
        if(node.left!=null){
            left=hasPath(node.left,target-node.val);
        }
        if(node.right!=null){
            right=hasPath(node.right,target-node.val);
        }
        return left||right;
    }
}