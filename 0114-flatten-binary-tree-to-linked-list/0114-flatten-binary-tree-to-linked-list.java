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
    public void flatten(TreeNode root) {
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if(root == null)
        return null;

        if(root.left == null && root.right == null)
        return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        root.left = null;

        if(left != null)
        {
           TreeNode tail = findLast(left);
           root.right = left;
           tail.right = right;
        }
        else
        {
           root.right = right;
        }
        return root;
    }public TreeNode findLast(TreeNode root){
        if(root==null){
            return null;
        }
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}