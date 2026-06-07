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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null){
            return list;
        }
        TreeNode c=root;
        TreeNode lastVisited=null;
        while(!st.isEmpty() || c!=null){
            if(c!=null){
                st.push(c);
                c=c.left;
            }else{
                TreeNode peek=st.peek();
                if(peek.right!=null && lastVisited!=peek.right){
                    c=peek.right;
                }else{
                    list.add(peek.val);
                    lastVisited=st.pop();
                }
            }
        }
        return list;
    }
}