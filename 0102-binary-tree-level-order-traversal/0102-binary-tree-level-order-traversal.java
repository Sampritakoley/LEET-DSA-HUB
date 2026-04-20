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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        q.offer(root);
        while(q.size()>0){
            int levelSize=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode c=q.poll();
                list.add(c.val);
                if(c.left!=null){
                    q.offer(c.left);
                }
                if(c.right!=null){
                    q.offer(c.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}