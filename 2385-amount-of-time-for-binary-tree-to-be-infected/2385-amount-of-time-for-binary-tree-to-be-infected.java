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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        TreeNode startNode=BuildParent(root,map,start);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> set=new HashSet<>();

        q.offer(startNode);
        set.add(startNode);
        int time=-1;
        while(q.size()>0){
            int size=q.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode c=q.poll();
                if(c.left!=null && !set.contains(c.left)){
                    q.offer(c.left);
                    set.add(c.left);
                }
                if(c.right!=null && !set.contains(c.right)){
                    q.offer(c.right);
                    set.add(c.right);
                }
                if(map.get(c)!=null && !set.contains(map.get(c))){
                    q.offer(map.get(c));
                    set.add(map.get(c));
                }
            }
            
        }
        return time;

    }public static TreeNode BuildParent(TreeNode root,HashMap<TreeNode,TreeNode> map,int start){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode startNode=null;
        while(q.size()>0){
            TreeNode curr=q.poll();
            if(curr.val==start){
                startNode=curr;
            }
            if(curr.left!=null){
              map.put(curr.left,curr);
              q.offer(curr.left);
            }
            if(curr.right!=null){
              map.put(curr.right,curr);
              q.offer(curr.right);
            }
        }
        return startNode;
    }
}