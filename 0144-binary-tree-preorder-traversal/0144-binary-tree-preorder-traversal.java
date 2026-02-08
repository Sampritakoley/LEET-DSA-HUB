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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        preorderTravel(root,res);
        return res;
    }public void preorderTravel(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        res.add(node.val);
        preorderTravel(node.left,res);
        preorderTravel(node.right,res);
    }
}