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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        q.offer(root);
        while(q.size()>0){
           int levelsize=q.size();
           for(int i=0;i<levelsize;i++){
              TreeNode c=q.poll();
              if(i==levelsize-1){
                list.add(c.val);
              }
              if(c.left!=null){
                q.offer(c.left);
              }
              if(c.right!=null){
                q.offer(c.right);
              }
           }
        }
        return list;
        
    }
}