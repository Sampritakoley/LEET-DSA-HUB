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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }
    private int dfs(TreeNode current, TreeNode parent, TreeNode grandparent) {
        if (current == null) {
            return 0;
        }
        int sum = 0;
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += current.val;
        }
        sum += dfs(current.left, current, parent);
        sum += dfs(current.right, current, parent);

        return sum;
    }
}