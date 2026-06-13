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

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        return countFrom(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int countFrom(TreeNode node, long target) {

        if (node == null) {
            return 0;
        }

        int count = 0;

        if (target == node.val) {
            count++;
        }

        count += countFrom(node.left, target - node.val);
        count += countFrom(node.right, target - node.val);

        return count;
    }
}
