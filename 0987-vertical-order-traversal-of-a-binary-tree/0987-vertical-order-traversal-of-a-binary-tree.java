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
    public class Pair{
        public TreeNode node;
        public int row;
        public int col;
        public  Pair(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Pair(root,0,0));
        while(q.size()>0){
            Pair p=q.poll();
            map.putIfAbsent(p.col,new TreeMap<>());
            map.get(p.col).putIfAbsent(p.row,new PriorityQueue<>());
            map.get(p.col).get(p.row).offer(p.node.val);
            if(p.node.left!=null){
               q.offer(new Pair(p.node.left,p.row+1,p.col-1));
            }
            if(p.node.right!=null){
                q.offer(new Pair(p.node.right,p.row+1,p.col+1));
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> val :map.values()){
            List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer> n:val.values()){
                while(!n.isEmpty()){
                    list.add(n.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}