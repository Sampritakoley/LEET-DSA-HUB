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
    TreeNode st;
    public int amountOfTime(TreeNode root, int start) {
       HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
       buildParent(root,start,parentMap);
       Queue<TreeNode> queue=new LinkedList<>();
       HashSet<TreeNode> set=new HashSet<>();
       queue.offer(st);int count=-1; set.add(st);
       while(queue.size()>0){
            int levelSize=queue.size();
            count++;
            for(int i=0;i<levelSize;i++){
               TreeNode n=queue.poll();
               if(n.left!=null && !set.contains(n.left)){
                  queue.offer(n.left);
                  set.add(n.left);
               }
               if(n.right!=null && !set.contains(n.right)){
                  queue.offer(n.right);
                  set.add(n.right);
               }
               if(parentMap.containsKey(n) && !set.contains(parentMap.get(n))){
                  queue.offer(parentMap.get(n));
                  set.add(parentMap.get(n));
               }
            }
       }
       return count;
    }
    public void buildParent(TreeNode root, int start,HashMap<TreeNode,TreeNode> parentMap){
        if(root.val==start){
            st=root;
        }
        if(root.left!=null){
            parentMap.put(root.left,root);
            buildParent(root.left,start,parentMap);
        }
        if(root.right!=null){
            parentMap.put(root.right,root);
            buildParent(root.right,start,parentMap);
        }
        return;
    }
}