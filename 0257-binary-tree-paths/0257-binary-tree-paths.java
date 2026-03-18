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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list=new ArrayList<>();
        print(""+root.val,list,root);
        return list;
    }public void print(String psf,List<String> list,TreeNode root){
        if(root.left==null && root.right==null){
            list.add(psf);
            return;
        }
        if(root.left!=null){
            print(psf+"->"+root.left.val,list,root.left);
        }
        if(root.right!=null){
            print(psf+"->"+root.right.val,list,root.right);
        }
    }
}