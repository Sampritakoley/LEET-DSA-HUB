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
        ArrayList<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return res;
        }
        addPathSum(res,list,root,targetSum);
        return res;
    }public void addPathSum(List<List<Integer>> res,List<Integer> list,TreeNode node,int target){
        if(node.left==null &&  node.right==null && node.val==target){
            list.add(node.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(node.left==null &&  node.right==null && node.val!=target){
            return;
        }
        list.add(node.val);
        if(node.left!=null){
            addPathSum(res,list,node.left,target-node.val);
        }
        if(node.right!=null){
            addPathSum(res,list,node.right,target-node.val);
        }
        list.remove(list.size()-1);
    }
}