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
    public List<Integer> preorderTraversal(TreeNode root) {
       Stack<TreeNode> st=new Stack<>();
       List<Integer> list=new ArrayList<>();
       if(root==null){
        return list;
       }
       st.push(root);
       while(st.size()>0){
          TreeNode c=st.pop();
          list.add(c.val);
          if(c.right!=null){
             st.push(c.right);
          }
          if(c.left!=null){
            st.push(c.left);
          }
       }
       return list;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna