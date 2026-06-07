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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> st=new Stack<>();
        TreeNode c=root;
        while(c!=null || !st.isEmpty()){
             while(c!=null){
                st.push(c);
                c=c.left;
             }
                c=st.pop();
                list.add(c.val);
                c=c.right;
             
             
        }
        return list;
    }
}