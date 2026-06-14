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
    public int sumNumbers(TreeNode root) {
        List<String> list=new ArrayList<>();
        FindRTL(list,"",root);
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=Integer.parseInt(list.get(i));
        }
        return sum;
    }public void FindRTL(List<String> list, String psf,TreeNode node){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            psf=psf+node.val;
            list.add(psf);
            return;
        }
        FindRTL(list,psf+node.val,node.left);
        FindRTL(list,psf+node.val,node.right);
        return;
    }
}