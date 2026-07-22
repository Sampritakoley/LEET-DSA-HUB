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
        TreeNode c=root;TreeNode lastPopped=null;
        while(c!=null || !st.isEmpty()){
            while(c!=null){
                st.push(c);
                c=c.left;
            }
            TreeNode peek=st.peek();
            if(peek.right!=null && lastPopped!=peek.right){
                c=peek.right;
            }else{
                list.add(peek.val);
                lastPopped=st.pop();
            }
        }
        return list;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna