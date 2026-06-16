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

    public String tree2str(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {

        if (node == null)
            return;

        sb.append(node.val);

        if (node.left != null) {
            sb.append("(");
            preorder(node.left, sb);
            sb.append(")");
        }

        if (node.right != null) {

            if (node.left == null)
                sb.append("()");

            sb.append("(");
            preorder(node.right, sb);
            sb.append(")");
        }
    }
}