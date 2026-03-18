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
        public long index;
        public Pair(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    //index 2x,2x+1 (0- based indexing)
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));int max=0;
        while(q.size()>0){
           int levelSize=q.size(); long first=0;long last=0;
           for(int i=0;i<levelSize;i++){
                Pair curr=q.poll();
                TreeNode currNode=curr.node;
                if(i==0){
                    first=curr.index;
                }
                if(i==levelSize-1){
                    last=curr.index;
                }
                if(currNode.left!=null){
                    q.offer(new Pair(currNode.left,curr.index*2));
                }
                if(currNode.right!=null){
                    q.offer(new Pair(currNode.right,(curr.index*2)+1));
                }
           }
           int width=(int) ((last-first)+1);
           max=width>max?width:max;
        }
        return max;
    }
}