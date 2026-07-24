class Solution {

    public TreeNode recoverFromPreorder(String traversal) {

        Stack<TreeNode> stack = new Stack<>();

        int i = 0;
        int n = traversal.length();

        while (i < n) {

            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {

                TreeNode parent = stack.peek();

                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }

            stack.push(node);
        }

        while (stack.size() > 1)
            stack.pop();

        return stack.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna