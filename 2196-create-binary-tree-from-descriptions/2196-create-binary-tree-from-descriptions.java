class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];
            TreeNode parent = nodes.computeIfAbsent(
                parentVal, val -> new TreeNode(val)
            );

            TreeNode child = nodes.computeIfAbsent(
                childVal, val -> new TreeNode(val)
            );
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children.add(childVal);
        }
        for (int val : nodes.keySet()) {
            if (!children.contains(val)) {
                return nodes.get(val);
            }
        }

        return null;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna