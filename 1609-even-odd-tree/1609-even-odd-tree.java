class Solution {

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int prev = (level % 2 == 0)
                    ? Integer.MIN_VALUE
                    : Integer.MAX_VALUE;

            while (size-- > 0) {

                TreeNode node = queue.poll();

                int val = node.val;

                if (level % 2 == 0) {

                    if (val % 2 == 0)
                        return false;

                    if (val <= prev)
                        return false;

                } else {

                    if (val % 2 != 0)
                        return false;

                    if (val >= prev)
                        return false;
                }

                prev = val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            level++;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna