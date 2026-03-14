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
    public int countNodes(TreeNode root) {
       if(root==null){
          return 0;
       } 

       int left=getLeftHeight(root);
       int right=getRightHeight(root);

       if(left==right){
          return (int)Math.pow(2,left)-1;
       }
       return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int getLeftHeight(TreeNode node){
        int count=0;
        while(node!=null){
            node=node.left;
            count++;
        }
        return count;
    }

    public int getRightHeight(TreeNode node){
        int count=0;
        while(node!=null){
            node=node.right;
            count++;
        }
        return count;
    }
}