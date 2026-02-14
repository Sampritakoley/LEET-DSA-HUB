/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map=new HashMap();
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> set=new HashSet<>();
        buidParentMap(map,root);
        q.offer(target);
        set.add(target);
        int distance=0;
        while(q.size()>0){
            int size=q.size();
            
            if(distance==k){
                break;
            }
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    q.offer(curr.right);
                    set.add(curr.right);
                }
                if(map.get(curr)!=null && !set.contains(map.get(curr))){
                    q.offer(map.get(curr));
                    set.add(map.get(curr));
                }
            }
            distance++;
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;

    }public static void buidParentMap(HashMap<TreeNode, TreeNode> map,TreeNode root){
        if (root == null) return;
        if(root.left!=null){
            map.put(root.left,root);
            buidParentMap(map,root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            buidParentMap(map,root.right);
        }
    }
}