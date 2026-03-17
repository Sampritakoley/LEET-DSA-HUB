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
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        buildParent(map,root);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> set=new HashSet<>();
        q.offer(target);set.add(target);
        int count=-1;
        ArrayList<Integer> list=new ArrayList<>();
        
        while(q.size()>0){
            int size=q.size(); 
            count++;
           
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                list.add(curr.val);
                if(curr.left!=null && !set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }

                if(curr.right!=null && !set.contains(curr.right)){
                    q.offer(curr.right);
                    set.add(curr.right);
                }

                if(map.containsKey(curr) && !set.contains(map.get(curr))){
                    q.offer(map.get(curr));
                    set.add(map.get(curr));
                }
            }
            if(k==count){
                return list;
            }
            list.clear();
        }
        return list;
    }
    public void buildParent(HashMap<TreeNode,TreeNode> map,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left,root);
            buildParent(map,root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            buildParent(map,root.right);
        }
    }
}