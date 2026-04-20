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
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.offer(root);
        boolean fromLeft=true;
        while(q.size()>0){
            int levelSize=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode c=q.poll();
                if(fromLeft){
                    list.add(c.val);
                }else{
                    list.add(0,c.val);
                }

                if(c.left!=null){
                    q.offer(c.left);
                }
                if(c.right!=null){
                    q.offer(c.right);
                }
            }
            res.add(list);
            fromLeft=!fromLeft;
        }
        return res;
    }
}