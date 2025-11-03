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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        findSum(root, targetSum, res,new ArrayList<>());
        return res;
    }
    public void findSum(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> list){
        
        if(root==null){
            return;
        }
        list.add(root.val);
        if(targetSum==root.val && root.left==null && root.right==null){
            res.add(new ArrayList<>(list));
        }
        
        
        findSum(root.left,targetSum-root.val,res,list);
        findSum(root.right,targetSum-root.val,res,list);
        list.remove(list.size()-1);
        return;
    }
}