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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        long maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIndex = queue.peek().index; 
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                long curIndex = current.index - minIndex;

                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;

                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, 2 * curIndex));
                }
                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, 2 * curIndex + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return (int) maxWidth;
    }

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
}