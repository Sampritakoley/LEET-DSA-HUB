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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>(); boolean isFromLeft=false;
        q.offer(root);
        while(q.size()>0){
            int levelSize=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode current=q.poll();
                if(isFromLeft){
                    list.addFirst(current.val);
                }else{
                    list.addLast(current.val);
                }

                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            isFromLeft=!isFromLeft;
            res.add(list);
        }
        return res;
    }
}