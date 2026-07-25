class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        dfs(root);

        return ans;
    }

    private void dfs(Node root) {

        if (root == null)
            return;

        for (Node child : root.children)
            dfs(child);

        ans.add(root.val);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna