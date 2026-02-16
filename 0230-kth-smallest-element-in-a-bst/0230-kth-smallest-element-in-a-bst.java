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
    int i = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        findkthSmallest(root,k);
        return res;
    }public void findkthSmallest(TreeNode root, int k){
        if(root==null){
             return;
        }
        findkthSmallest(root.left,k);
        i++;
        if(k==i){
            res=root.val;
            return;
        }
        findkthSmallest(root.right,k);
    }
}