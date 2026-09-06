class Solution {

    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int answer = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                answer = level;
            }

            level++;
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna