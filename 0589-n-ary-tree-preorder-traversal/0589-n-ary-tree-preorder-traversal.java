class Solution {

    public List<Integer> preorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            Node node = st.pop();

            ans.add(node.val);

            List<Node> children = node.children;

            for (int i = children.size() - 1; i >= 0; i--)
                st.push(children.get(i));
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna