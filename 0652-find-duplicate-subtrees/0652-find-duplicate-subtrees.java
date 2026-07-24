class Solution {

    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {

        if (node == null)
            return "#";

        String left = serialize(node.left);

        String right = serialize(node.right);

        String serial = node.val + "," + left + "," + right;

        int freq = map.getOrDefault(serial, 0);

        if (freq == 1) {
            result.add(node);
        }

        map.put(serial, freq + 1);

        return serial;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna